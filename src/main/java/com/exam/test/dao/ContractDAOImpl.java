package com.exam.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.ChangeApplyStateVO;
import com.exam.test.model.ContractBlockVO;
import com.exam.test.model.ContractVO;

@Repository
public class ContractDAOImpl implements ContractDAO{

	@Autowired
	SqlSession sqlSession;
	
	public boolean insertTransactionHash(ContractBlockVO contractBlock) {
		try {
			sqlSession.update("contractMapper.insertTransaction", contractBlock);
		} catch(Exception e) {
			System.out.println("insertTransaction Fail : "+e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean checkRecordBlock() {
		try {
			sqlSession.insert("insertTransaction");
		} catch(Exception e) {
			System.out.println("insertTransaction Fail : "+e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public int sendContract(ContractVO contract) {
		sqlSession.insert("contractMapper.sendContract",contract);
		return contract.get_id();
	}
	
	@Override
	public List<ContractVO> getMyContract(AuthInfoVO authInfo) {
		// TODO Auto-generated method stub
		if(authInfo.getRole().equals("employee")) {
			return sqlSession.selectList("contractMapper.getMyContractEE",authInfo);
		}
		return sqlSession.selectList("contractMapper.getMyContractER",authInfo);
	}

	@Override
	public ContractVO getContract(int contract_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("contractMapper.getContract",contract_id);
	}

	@Override
	public boolean updateContractState(int contract_id, String state) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("contract_id", contract_id);
		map.put("state", state);
		try {
			sqlSession.update("contractMapper.updateContractState",map);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<ContractVO> getIngContract(AuthInfoVO authInfo) {
		// TODO Auto-generated method stub
		if(authInfo.getRole().equals("employee")) {
			return sqlSession.selectList("contractMapper.getIngContractEmployee",authInfo);
		}
		
		return sqlSession.selectList("contractMapper.getIngContractEmployer",authInfo);
		
	}

	@Override
	public String changeApplyState(ChangeApplyStateVO changeApplyState) {
		System.out.println(changeApplyState);
		try {
			sqlSession.update("contractMapper.changeApplyState", changeApplyState);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "fail";
		}
		return "success";
	}

	@Override
	public List<ContractBlockVO> getNotConfirmContractBlock() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("contractMapper.getNotConfirmContractBlock");
	}

	@Override
	public boolean insertBlockInfo(ContractBlockVO contractBlock) {
		try {
			sqlSession.update("contractMapper.insertBlockInfo",contractBlock);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean confirmContractBlock(AuthInfoVO authInfo) {
		List<ContractVO> contract = sqlSession.selectList("contractMapper.checkRecordBlockEmployer", authInfo);
		if(contract.size()==0) {
			return false;
		}
		return true;
	}

	@Override
	public int socketCheckRecoredBlock(AuthInfoVO info) {
		int notConfirmCount=0;
		if(info.getRole().equals("employee")) {
			notConfirmCount = sqlSession.selectOne("contractMapper.socketCheckRecordBlockEmployee", info);
		}else if(info.getRole().equals("employer")) {
			notConfirmCount = sqlSession.selectOne("contractMapper.socketCheckRecordBlockEmployer", info);
		}
		return notConfirmCount;
	}


	
}
