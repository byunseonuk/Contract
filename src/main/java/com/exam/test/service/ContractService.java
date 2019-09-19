package com.exam.test.service;

import java.util.List;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.ChangeApplyStateVO;
import com.exam.test.model.ContractBlockVO;
import com.exam.test.model.ContractVO;

public interface ContractService {

	public boolean insertTransactionHash(ContractVO contract) throws Exception;
	public List<ContractVO> getMyContract(AuthInfoVO authInfo);
	public ContractVO getContract(int contract_id);
	public boolean acceptContract(ContractVO contract);
	public List<ContractVO> getIngContract(AuthInfoVO authInfo);
	public int sendContract(ContractVO contract);
	public String changeApplyState(ChangeApplyStateVO changeApplyState);
	public List<ContractBlockVO> getNotConfirmContractBlock();
	public boolean insertBlockInfo(ContractBlockVO contractBlock);
	public boolean confirmContractBlock(AuthInfoVO authInfo);
	public SseEmitter checkRecoredBlockEvent(AuthInfoVO authInfo);
	public boolean socketCheckRecoredBlock(AuthInfoVO info);

}
