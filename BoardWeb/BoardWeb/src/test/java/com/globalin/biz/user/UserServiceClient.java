package com.globalin.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService=(UserService)container.getBean("userService");
		
		UserVO vo=new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user=userService.getUser(vo);
		
		if(user!=null) {
			System.out.println(user.getName()+"님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}
		
		//JointPoint.getArgs() 확인해 보기 위해 인자 없는 함수 호출 부분을 주석처리 했음
//		List<UserVO> list=userService.getUserList();
//		
//		for (UserVO userVO : list) {
//			System.out.println(userVO.toString());
//		}
//		
		container.close();
		
	}
}
