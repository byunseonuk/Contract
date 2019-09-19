package com.exam.test.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import com.exam.test.dao.ContractDAO;
import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.ChangeApplyStateVO;
import com.exam.test.model.ContractBlockVO;
import com.exam.test.model.ContractVO;
import com.exam.test.model.RecruitmentVO;

@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
	ContractDAO contractDAO;

	private final SseEmitter emitter = new SseEmitter();
	final static private String FAIL=  "0x0000000000000000000000000000000000000000000000000000000000000000";
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean insertTransactionHash(ContractVO contract) throws Exception{
		Web3j web3 = Web3j.build(new HttpService("http://192.168.0.8:8546"));
		EthAccounts ethAccounts = web3.ethAccounts().sendAsync().get();
		String accounts[] = ethAccounts.getAccounts().toArray(new String[0]);
		Credentials credentials = WalletUtils.loadCredentials("1234", "C:\\Users\\byuns\\Downloads\\accountWallet.json");

		/*	트랜잭션 생성 및 전송	시작*/
		
		// Nonce값 구해오기
		EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
				accounts[0], DefaultBlockParameterName.LATEST).send();
		BigInteger nonce = ethGetTransactionCount.getTransactionCount();

		
		// 계약정보 Json형태로 변경 후 16진수 String으로 변경
		String ContractData = Numeric.toHexString(contract.toJsonString().getBytes());
		// nonce, gas_limit, gas_price, account, input 값지정해서 트랜잭션 생성
		RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT, accounts[0], ContractData);
		// sign & send transaction
		byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
		String hexValue = Numeric.toHexString(signedMessage);
		EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
		
		/*	트랜잭션 생성 및 전송	끝*/
		
		if(ethSendTransaction.getTransactionHash()!=FAIL) {
			ContractBlockVO contractBlock = new ContractBlockVO();
			contractBlock.setContract_id(contract.get_id());
			System.out.println(contract.get_id());
			contractBlock.setTransactionHash(ethSendTransaction.getTransactionHash());
			if(contractDAO.insertTransactionHash(contractBlock)) {
				return contractDAO.updateContractState(contract.get_id(),"completed");
			}
		}
		return false;
 
	}
	

	@Override
	public List<ContractVO> getMyContract(AuthInfoVO authInfo) {
		
		return contractDAO.getMyContract(authInfo);
	}

	@Override
	public ContractVO getContract(int contract_id) {
		// TODO Auto-generated method stub
		return contractDAO.getContract(contract_id);
	}

	@Override
	public boolean acceptContract(ContractVO contract) {
		// TODO Auto-generated method stub
		return contractDAO.updateContractState(contract.get_id(),"accept");
	}
	
	@Override
	public List<ContractVO> getIngContract(AuthInfoVO authInfo) {
		return contractDAO.getIngContract(authInfo);
	}
	
	@Override
	public int sendContract(ContractVO contract) {
		// TODO Auto-generated method stub
		return contractDAO.sendContract(contract);
	}
	
	@Override
	public String changeApplyState(ChangeApplyStateVO changeApplyState) {
		String changeResult = contractDAO.changeApplyState(changeApplyState);
		return changeResult;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	@Override
	public List<ContractBlockVO> getNotConfirmContractBlock() {
		// TODO Auto-generated method stub
		return contractDAO.getNotConfirmContractBlock();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean insertBlockInfo(ContractBlockVO contractBlock) {
		// TODO Auto-generated method stub
		return contractDAO.insertBlockInfo(contractBlock);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean confirmContractBlock(AuthInfoVO authInfo) {
		// TODO Auto-generated method stub
		return contractDAO.confirmContractBlock(authInfo);
	}


	@Override
	public SseEmitter checkRecoredBlockEvent(AuthInfoVO authInfo) {
		boolean check = false;
		if(authInfo.getRole().equals("employee")) {
			//check = contractDAO.checkRecordBlockEmployee(authInfo.get_id());
		}else if(authInfo.getRole().equals("employer")) {
			//check = contractDAO.checkRecordBlockEmployer(authInfo.get_id());
		}
		
		try {
			emitter.send(true);
		} catch (IOException e) {
			e.printStackTrace();
			emitter.completeWithError(e);
		}
		
		return emitter;
		
	}

	@Override
	public boolean socketCheckRecoredBlock(AuthInfoVO info) {
		int notConfirmCount = contractDAO.socketCheckRecoredBlock(info);
		if(notConfirmCount==0) {
			return false;
		}
		return true;
	}


}
