package com.exam.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.test.model.SimpleApplicantVO;
import com.exam.test.model.UserVO;
import com.exam.test.model.AuthInfoVO;

import com.exam.test.model.RecruitThumbVO;
import com.exam.test.model.RecruitmentVO;

import com.exam.test.service.RecruitService;
import org.json.simple.parser.JSONParser;

@Controller
public class RecruitmentController {
	
	@Autowired
	RecruitService recruitService;
	
	@RequestMapping(value="recruit/recruitForm")
	public String recruitForm() {
		return "recruit/recruitForm";
	}
	
	@RequestMapping(value="recruit/insertRecruit", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> insertRecruit(RecruitmentVO recruitVO, HttpServletRequest request) {
		System.out.println(recruitVO);
		
		Map<String,String> resultMap = new HashMap<String,String>();
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		recruitVO.setOwner(authInfo.get_id());
		System.out.println("Session_id"+authInfo.get_id());
		try {
			if(recruitService.insertRecruit(recruitVO)) {
				resultMap.put("result", "success");
				return resultMap;
			}else {
				resultMap.put("result", "fail");
				return resultMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "error");
			return resultMap;
		}
	}
	
	@RequestMapping(value="recruit/myRecruit")
	public String myRecruit(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		List<RecruitmentVO> myRecruitList =  recruitService.getMyRecruitList(authInfo.get_id());
		for(RecruitmentVO r:myRecruitList) {
			System.out.println(r.getIsEnded());
			System.out.println(r.getEndDate());
		}
		model.addAttribute("myRecruitList", myRecruitList);
		return "recruit/myRecruit";
	}
	
	@RequestMapping(value="recruit/recruitArea")
	public String getAreaRecruitList(HttpServletRequest request, Model model) throws Exception {	
		int area = Integer.parseInt(request.getParameter("aCod"));
		
		List<RecruitThumbVO> recruitList = recruitService.getAreaRecruitList(area);
		model.addAttribute("recruitList", recruitList);
		model.addAttribute("area", area);
		return "public/recruitList";
	}
	
	@RequestMapping(value="recruit/loadAllRecruit")
	@ResponseBody
	public Map<String,Object> loadAllRecruit(@RequestParam(name="start", required=false, defaultValue="0") int start){
		
		Map<String,Object> result = new HashMap<String,Object>();
		List<RecruitThumbVO> recruitList = recruitService.getRecruitList(start);
		if(recruitList!=null) {
			result.put("result", "success");
			result.put("items", recruitList);
		}else {
			result.put("result", "empty");
		}
		
		return result;
		
		
	}
	
	@RequestMapping(value="recruit/detailView")
	public String recruitDetailView(HttpServletRequest request, Model model) throws Exception {
		
		int recruit_id = Integer.parseInt(request.getParameter("recnum"));
		
		RecruitmentVO recruit = recruitService.getRecruit(recruit_id);
		model.addAttribute("recruit", recruit);
		return "recruit/showRecruit";
	}
	
	
	
	@RequestMapping(value="recruit/applicantList", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> applyList(HttpServletRequest request, Model model) throws Exception{
		int recruit_id = Integer.parseInt(request.getParameter("recnum"));
		List<SimpleApplicantVO> applicantList = recruitService.getApplicantList(recruit_id);

		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(applicantList.isEmpty()) {
			resultMap.put("result", "empty");
		}else {
			resultMap.put("result","success");
			resultMap.put("data", applicantList);
		}
		return resultMap;
	}
}
