package com.globalin.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	@Pointcut("execution(* com.globalin.biz..*Impl.*(..))")
	public void allPointcut() {}

	@AfterThrowing(pointcut = "allPointcut()",throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method=jp.getSignature().getName();
//		System.out.println("[예외처리]"+method+"() 메소드 실행 중 발생된 예외 메시지 : "+exceptObj.getMessage());
		System.out.println(method+"() 메소드 실행 예외 발생!!");
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 식별자 에러");
		}else if(exceptObj instanceof NumberFormatException){
			System.out.println("부적절한 숫자 형식");
		}else if(exceptObj instanceof Exception){
			System.out.println("문제 발생했다");
		}
	}
}
