package com.exam.test.dao;

import java.util.List;

import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.ChangeApplyStateVO;
import com.exam.test.model.ContractBlockVO;
import com.exam.test.model.ContractVO;

public interface ContractDAO {

	boolean insertTransactionHash(ContractBlockVO contractBlock);
	public List<ContractVO> getMyContract(AuthInfoVO authInfo);
	public ContractVO getContract(int contract_id);
	public boolean updateContractState(int contract_id, String state);
	public List<ContractVO> getIngContract(AuthInfoVO authInfo);
	public int sendContract(ContractVO contract);
	public String changeApplyState(ChangeApplyStateVO changeApplyState);
	public List<ContractBlockVO> getNotConfirmContractBlock();
	public boolean insertBlockInfo(ContractBlockVO contractBlock);
	boolean confirmContractBlock(AuthInfoVO authInfo);
	int socketCheckRecoredBlock(AuthInfoVO authInfo);
}
