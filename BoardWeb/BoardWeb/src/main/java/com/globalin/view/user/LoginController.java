package com.globalin.view.user;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) { //Get 방식
		System.out.println("로그인 화면으로 이동....");
		
		vo.setId("test");
		vo.setPassword("test123");
		
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session){ //Post 방식
		
		System.out.println("로그인 인증 처리...");
		UserVO user=userDAO.getUser(vo);
		//3. 화면 네비게이션
		if(user!=null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
		
	}

}
