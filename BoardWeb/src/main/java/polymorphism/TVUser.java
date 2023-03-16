package polymorphism;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		// Factory pattern
//		BeanFactory Factory=new BeanFactory();
//		
//		TV tv=(TV) Factory.getBean("samsung");
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//
//		TV lgTv=(TV) Factory.getBean("lg");
//		lgTv.powerOn();
//		lgTv.volumeUp();
//		lgTv.volumeDown();
//		lgTv.powerOff();
		
		

		// 1. Spring Container를 구동한다.

	 	/*
		 * new GenericXmlApplicationContext 클래스 - 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 컨테이너
		 * XMLWebApplicationContext 클래스 - 웹 기반의 스프링 어플리케이션을 개발할 때 사용하는 컨테이너임
		 */

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2. Spring Container로 부터 필요한 객체를 요청(lookup)
		
		
		TV tv = (TV)factory.getBean("tv");
		TV tv1 = (TV)factory.getBean("tv");

		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		
		tv1.volumeDown();
		
		

		// 3. Spring Container를 종료한다.
		factory.close();
		

//		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		TV tv=context.getBean(LgTV.class);
//		tv.powerOn();

	}
}
