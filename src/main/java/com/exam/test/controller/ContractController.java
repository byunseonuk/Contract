package com.exam.test.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.ChangeApplyStateVO;
import com.exam.test.model.ContractVO;
import com.exam.test.service.ContractService;

@Controller
public class ContractController {
	
	@Autowired
	ContractService contractService;
	
	
	@RequestMapping(value="contract/contractForm", method=RequestMethod.POST)
	public String submitAppicant(HttpServletRequest request, Model model) throws Exception {
		int employee = Integer.parseInt(request.getParameter("employee"));
		int employer = Integer.parseInt(request.getParameter("employer"));
		int apply = Integer.parseInt(request.getParameter("apply"));
		model.addAttribute("employee", employee);
		model.addAttribute("employer", employer);
		model.addAttribute("apply", apply);
		return "contract/contractForm";
	}
	
	
//	@RequestMapping(value="contract/recordBlock",method=RequestMethod.POST)
//	@ResponseBody
//	public String testContract(HttpServletRequest request, ContractVO contract, Model model) throws Exception{
//		System.out.println(contract);
//		Web3j web3 = Web3j.build(new HttpService("http://192.168.38.129:8545"));
//		//Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
//		//String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//		//System.out.println(clientVersion);
//		
//		EthAccounts ethAccounts = web3.ethAccounts().sendAsync().get();
//		String accounts[] = ethAccounts.getAccounts().toArray(new String[0]);
//		//System.out.println(accounts[0]);
//		
//		Credentials credentials = WalletUtils.loadCredentials("1234", "C:\\Users\\byuns\\Downloads\\accountWallet.json");
//		System.out.println(credentials);
//		
//		EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
//				accounts[0], DefaultBlockParameterName.LATEST).send();
//		BigInteger nonce = ethGetTransactionCount.getTransactionCount();
//		
//		//BigInteger amountWei = Convert.toWei("0.131313", Convert.Unit.ETHER).toBigInteger();
//		//RawTransaction rawTransaction  = RawTransaction.createEtherTransaction(
//	    //         nonce, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT , accounts[1], amountWei);
//		
//		// 怨꾩빟�꽌 HEX String 媛�
//		
//		String ContractData = Numeric.toHexString(contract.toJsonString().getBytes());
//		RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT, accounts[0], ContractData);
//		// sign & send our transaction
//		byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
//		String hexValue = Numeric.toHexString(signedMessage);
//		EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
//		//  �듃�옖�옲�뀡 �빐�떆媛�
//		System.out.println(ethSendTransaction.getTransactionHash());
//		
//		//String s = "Test Data";
//		System.out.println("Test Data Hex: "+Numeric.toHexString(contract.toString().getBytes()));
//		
//		// �듃�옖�옲�뀡 媛��졇�삤湲�
//		Optional<Transaction> transaction = web3.ethGetTransactionByHash(ethSendTransaction.getTransactionHash()).send().getTransaction();
//		System.out.println("transaction: "+transaction);
//		//String data = null;
//		//JSONObject contractDataJSON;
//		if(transaction.isPresent()) {
//			
//			if(contractService.insertTransactionHash(ethSendTransaction.getTransactionHash())) {
//				return "true";
//			}else {
//				return "false";
//			}
//		}
//		return "false";
//	}
	
	@RequestMapping(value="contract/recordBlock",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> testContract(HttpServletRequest request, ContractVO contract) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		//System.out.println(Integer.parseInt(request.getParameter("_id")));
		System.out.println(contract);
		if(contractService.insertTransactionHash(contract)) {
			result.put("result", "success");
		}else {
			result.put("result", "error");
		}
			
		return result;
	}
	
	@RequestMapping(value="contract/sendContract", method=RequestMethod.POST)
	public String sendContract(HttpServletRequest request, Model model, ContractVO contract) throws Exception {
		int apply_id = Integer.parseInt(request.getParameter("apply_id"));
		int contract_id = contractService.sendContract(contract);
		
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		
		ChangeApplyStateVO changeApplyState = new ChangeApplyStateVO();
		changeApplyState.setApply_id(apply_id);
		changeApplyState.setState("selected");
		
		String changeResult="";
		List<ContractVO> contractList = new ArrayList<ContractVO>();
		
		if(contract_id!=0) {
			changeApplyState.setContract_id(contract_id);
			changeResult = contractService.changeApplyState(changeApplyState);
			if(changeResult.equals("fail")) {
				model.addAttribute("msg", "fail");
				model.addAttribute("employee", contract.getEmployee_id());
				model.addAttribute("employer", contract.getEmployer_id());
				model.addAttribute("apply", apply_id);
				return "public/contractForm";
			}else if(changeResult.equals("success")){
				contractList = contractService.getMyContract(authInfo);
				model.addAttribute("contractList", contractList);
			}
		}else {
			model.addAttribute("msg", "fail");
			model.addAttribute("employee", contract.getEmployee_id());
			model.addAttribute("employer", contract.getEmployer_id());
			model.addAttribute("apply", apply_id);
			return "contract/contractForm";
		}
		return "redirect:myContract";
	}
	
	@RequestMapping(value="contract/myContract")
	public String myContractList(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		String role = authInfo.getRole();
		List<ContractVO> contractList = contractService.getMyContract(authInfo);
		
		model.addAttribute("contractList", contractList);
		return "contract/myContract";
	}
	
	@RequestMapping(value="contract/viewContract")
	public String viewContract(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) throws Exception {
		int contract_id = Integer.parseInt(request.getParameter("contract_id"));
		ContractVO contract = contractService.getContract(contract_id);
		if(contract!=null) {
			model.addAttribute("contract", contract);
		}else {
			redirectAttributes.addFlashAttribute("msg", "fail");
			String referer = request.getHeader("Referer");
			return "redirect:"+referer;
		}
		return "contract/viewContract";
	}
	
	@RequestMapping(value="contract/acceptContract")
	@ResponseBody
	public String acceptContract(HttpServletRequest request) throws Exception {
		int _id = Integer.parseInt(request.getParameter("_id"));
		String state = request.getParameter("state");
		ContractVO contract = new ContractVO();
		contract.set_id(_id);
		contract.setState(state);
		if(contractService.acceptContract(contract)) {
			return "success";
		}else {
			return "fail";
		}	
	}
	
	@RequestMapping(value="contract/ingContract")
	public String ingContract(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		String role = authInfo.getRole();
		List<ContractVO> ingcontractList = new ArrayList<ContractVO>();
	
		ingcontractList = contractService.getIngContract(authInfo);
		model.addAttribute("ingcontractList", ingcontractList);
		
		return "contract/ingContract";
	}
	
	@RequestMapping(value="contract/contractRecordBlock", method=RequestMethod.POST)
	public String contract_registForm(HttpServletRequest request, Model model) throws Exception{
		int contract_id = Integer.parseInt(request.getParameter("_id"));
		ContractVO contract = contractService.getContract(contract_id);
		model.addAttribute("contract", contract);
		return "contract/contractRecordBlock";
	}
	
	@RequestMapping(value="contract/checkRecordBlockEvent")
	public SseEmitter checkRecordBlockEvent(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		return contractService.checkRecoredBlockEvent(authInfo);
	}

}
