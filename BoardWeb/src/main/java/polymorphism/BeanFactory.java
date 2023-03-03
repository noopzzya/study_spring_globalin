package polymorphism;

public class BeanFactory {

	public Object getBean(String beanName) {
		
		// 디자인 패턴
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;		
	}
	
}
