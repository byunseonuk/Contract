package com.exam.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.exam.test.model.AuthInfoVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginInfo")!=null) {
			session.removeAttribute("loginInfo");
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		AuthInfoVO authInfo = (AuthInfoVO) modelMap.get("loginInfo");
		System.out.println(authInfo);
		modelAndView.setViewName("public/login");
		if(authInfo!=null) {
			session.setAttribute("loginInfo",authInfo);
			response.sendRedirect("/test");
		}else {
			modelAndView.addObject("msg","아이디 또는 비밀번호를 확인해주세요");
			response.sendRedirect("loginForm");
		}
	}
	
}
