package com.exam.test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;

import com.exam.test.model.ContractBlockVO;
import com.exam.test.model.ContractVO;
import com.exam.test.service.ContractService;

public class CheckBlockTask {
	
	@Autowired
	ContractService contractService;
	// 트랜잭션 블록 생성 여부 수정하기
	@Scheduled(fixedDelay=30000, initialDelay=100000)
	public void checkBlock() {
		List<ContractBlockVO> contractBlockList = contractService.getNotConfirmContractBlock();
		Web3j web3 = Web3j.build(new HttpService("http://192.168.0.8:8546"));
		//Optional<Transaction> transaction = null;
		EthTransaction ethTransaction = null;
		Transaction transaction = null;
		if(contractBlockList!=null) {
			for(ContractBlockVO contractBlock: contractBlockList) {
				try {
					/// getBlock by TransactionHash 트랜잭션해시값으로 저장되어있는 블럭정보 가져옴.
					//transaction = web3.ethGetTransactionByHash(contract.getTransactionHash()).send().getTransaction();
					ethTransaction = web3.ethGetTransactionByHash(contractBlock.getTransactionHash()).send();
					transaction = ethTransaction.getTransaction().get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if(transaction.getBlockNumber()!=null) {
					contractBlock.setBlockHash(transaction.getBlockHash());
					contractBlock.setBlockNumber(transaction.getBlockNumberRaw());
					if(!contractService.insertBlockInfo(contractBlock)) {
						System.out.println("Error setRecordTransaction.............");
					}
				}
			}
		}
	}	
}
