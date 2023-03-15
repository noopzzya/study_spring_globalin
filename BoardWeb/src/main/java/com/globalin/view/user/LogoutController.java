package com.globalin.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");

		// MVC1 logout_proc.jsp 소스
		HttpSession session = request.getSession(); // 추가
		session.invalidate();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		
		// 응답화면
		return mav;
	}

}
