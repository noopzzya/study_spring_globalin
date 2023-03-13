package com.globalin.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.globalin.view.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("로그아웃 처리");
		
		// MVC1 logout_proc.jsp 소스 
		HttpSession session = request.getSession(); // 추가
		session.invalidate();

		return "login";
		
	}

}
