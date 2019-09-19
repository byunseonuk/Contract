package com.exam.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.LoginVO;
import com.exam.test.model.UserVO;
import com.exam.test.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "loginForm")
	public String loginForm() {
		return "public/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void login(LoginVO loginVO, Model model) throws Exception {
		AuthInfoVO authInfo = userService.login(loginVO);
		System.out.println(authInfo);
		model.addAttribute("loginInfo", authInfo);
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		return "public/main";
	}

	@RequestMapping(value = "signupForm")
	public String signupForm() {
		return "public/signup";
	}
	
	@RequestMapping(value = "signup/checkID", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> checkID(@RequestParam(name="identifier") String identifier) {
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			if(userService.checkID(identifier)) {
				resultMap.put("result", "possible");
				return resultMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "error");
			return resultMap;
		}
		resultMap.put("result", "impossible");
		return resultMap;
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> signup(UserVO userVO, Model model) throws Exception {
		Map<String, String> resultMap = new HashMap<String, String>();
		if (userService.signup(userVO)) {
			resultMap.put("result", "success");
			return resultMap;
		}
		resultMap.put("result", "fail");
		return resultMap;
	}


	@RequestMapping(value = "mypage")
	public String myPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("loginInfo");
		UserVO user = userService.getMyInfo(authInfo.get_id());
		model.addAttribute("myInfo", user);
		return "user/myPage";
	}
	
	@RequestMapping(value = "changeMyInfo")
	public String changeInfoPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		AuthInfoVO authInfo = (AuthInfoVO)session.getAttribute("loginInfo");
		UserVO user = userService.getMyInfo(authInfo.get_id());
		model.addAttribute("myInfo", user);
		return "user/changeInfoForm";
	}
}
