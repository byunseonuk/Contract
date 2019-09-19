package com.exam.test.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.test.model.ApplicantVO;
import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.CareerVO;
import com.exam.test.model.CertificateVO;
import com.exam.test.model.LanguageVO;
import com.exam.test.model.ResumeVO;
import com.exam.test.model.SimpleApplyVO;
import com.exam.test.model.UserVO;
import com.exam.test.service.ContractService;
import com.exam.test.service.ResumeService;

@Controller
public class ResumeController {
	
	@Autowired
	ResumeService resumeService;
	
	@Autowired
	ContractService contractService;
	
	@RequestMapping(value="resume/resumeForm")
	public String resumeForm() throws Exception{
		return "resume/resumeForm";
	}
	
	@RequestMapping(value="resume/insertResume")
	public String insertResume(ResumeVO resume, CareerVO career, CertificateVO certificate, LanguageVO language) throws Exception{
		System.out.println(resume);
		int resume_id;
		try {
			/*resumeService.insertCareer(career,resume_id);
			resumeService.insertCertificate(certificate,resume_id);
			resumeService.insertLanguage(language,resume_id);*/
			resume_id = resumeService.insertResume(resume, career, certificate, language);
		}catch(Exception e) {
			e.printStackTrace();
			return "resume/resumeForm";
		}
		if(resume_id==-1)
			return "resume/myResume";
		else 
			return "resume/resumeForm";
	}
	
	@RequestMapping(value="resume/showResume")
	public String showResume(HttpServletRequest request, Model model) throws Exception {
		int resume_no = Integer.parseInt(request.getParameter("resume_id"));
		ResumeVO resume = resumeService.getResume(resume_no);
		List<CareerVO> careerList = resumeService.getCareer(resume_no);
		List<CertificateVO> certificateList = resumeService.getCertificate(resume_no);
		List<LanguageVO> languageList = resumeService.getLanguage(resume_no);
		UserVO user = resumeService.getApplicantInfo(resume.getUser_id());
		model.addAttribute("resume",resume);
		model.addAttribute("careerList",careerList);
		model.addAttribute("certificateList",certificateList);
		model.addAttribute("languageList",languageList);
		model.addAttribute("user",user);
//		System.out.println(careerList);
//		System.out.println(certificateList);
//		System.out.println(languageList);
		return "resume/showResume";
	}
	
	@RequestMapping(value="resume/myResume")
	public String myResumeList(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		List<ResumeVO> resumeList = resumeService.getMyResumeList(authInfo.get_id());
		model.addAttribute("resumeList", resumeList);
		return "resume/myResume";
	}
	
	@RequestMapping(value="apply/applyForm")
	public String applyForm(@RequestParam(name="recnum") int recnum, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		System.out.println(authInfo.get_id());
		List<ResumeVO> resumeList = resumeService.getMyResumeList(authInfo.get_id());
		System.out.println(resumeList);
		model.addAttribute("resumeList", resumeList);
		model.addAttribute("recruit_id",recnum);
		return "apply/applyForm";
	}
	
	@RequestMapping(value="apply/apply")
	@ResponseBody
	public String submitApplicant(HttpServletRequest request, ApplicantVO applicant) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		applicant.setUser_no(authInfo.get_id());
		if(resumeService.submitApplicant(applicant)) {
			return "true";
		}
		return "false";
	}
	

	@RequestMapping(value="apply/myApply",  method=RequestMethod.POST)
	public String myApplyList(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO) session.getAttribute("loginInfo");
		List<SimpleApplyVO> applyList = resumeService.myApplyList(authInfo.get_id());
		model.addAttribute("applyList", applyList);
		return "apply/myApply";
	}
	
	@RequestMapping(value="resume/modifyResumeForm", method=RequestMethod.POST)
	public String modifyResumeForm(HttpServletRequest request, Model model) throws Exception {
		
		int resume_id = Integer.parseInt(request.getParameter("resume_id"));
		
		ResumeVO resume = resumeService.getResume(resume_id);
		List<CareerVO> careerList = resumeService.getCareer(resume_id);
		List<CertificateVO> certificateList = resumeService.getCertificate(resume_id);
		List<LanguageVO> languageList = resumeService.getLanguage(resume_id);
		
		model.addAttribute("resume",resume);
		System.out.println("123"+resume.get_id());
		model.addAttribute("careerList",careerList);
		model.addAttribute("certificateList",certificateList);
		model.addAttribute("languageList",languageList);
		model.addAttribute("method", "modify");
		
		return "resume/resumeForm";
	}
	
	@RequestMapping(value="resume/modifyResume", method=RequestMethod.POST)
	public String modifyResume(HttpServletRequest request, ResumeVO resume, CareerVO career, CertificateVO certificate, LanguageVO language) throws Exception{
		System.out.println("Enter modifyResume");
		System.out.println(request.getParameter("_id"));
		System.out.println(resume);
		System.out.println(career);
		System.out.println(certificate);
		System.out.println(language);
		resume.set_id(Integer.parseInt(request.getParameter("_id")));
		try {
			resumeService.modifyResume(resume);
			resumeService.modifyCareer(career,resume.get_id());
			resumeService.modifyCertificate(certificate,resume.get_id());
			resumeService.modifyLanguage(language,resume.get_id());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "resume/myResume";
	}

	
}
