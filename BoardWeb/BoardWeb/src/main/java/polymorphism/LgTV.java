package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//id를 등록해주면 됨
@Component("tv")
public class LgTV implements TV{
	
	//@Autowired : 변수 위에 설정하여 해당하는 타입 객체를 찾아서 자동으로 할당하는 기능
	//@Qualifier("apple") : 객체가 여러개일 경우 특저 객체의 이름을 이용하여 의존성을 주입하는 기능
	@Autowired
	//@Qualifier("apple")
//	@Resource(name="apple")
	private Speaker speaker;
	
//	@Autowired
//	@Qualifier("sony")
//	private Speaker speaker2;
	
	public LgTV() {
		System.out.println("====> Lg TV 객체 생성");
	}
	

	@Override
	public void powerOn() {
		System.out.println("LgTV --- 전원 켠다.");		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV --- 전원 끈다.");		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//speaker2.volumeUp();
		//System.out.println("LgTV --- 소리 올린다.");		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("LgTV --- 소리 내린다.");		
	}
	
		
}
