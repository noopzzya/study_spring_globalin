package com.globalin.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리..");
		/*
		HttpSession session = request.getSession();
		
		session.invalidate();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		
		return mav;
		*/
		session.invalidate();
		
		return "login.jsp";
	}

}
