package com.globalin.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;
import com.globalin.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("로그인 처리");
		
		// MVC1 login_proc.jsp 소스 
		// 1. 사용자가 입력한 정보를 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");

		// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

		// 3. 화면 네비게이션
			if(user != null) {
				return "getBoardList.do";
			} else {
				return "login";
			}
		// MVC1 login_proc.jsp 소스 끝
		
	}

}
