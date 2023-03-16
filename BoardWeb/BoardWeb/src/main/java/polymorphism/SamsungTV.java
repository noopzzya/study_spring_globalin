package polymorphism;

public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	
	public void initMethod() {
		System.out.println("initMethod : 객체 초기화 작업중");
	}
	
	public void destroyMethod() {
		System.out.println("destroyMethod : 객체 소멸 작업중");
	}
	
	public SamsungTV() {
		System.out.println("=====> SamsungTV(1) 객체 생성...."); 
	}

	public SamsungTV(Speaker speaker) { //생성자 injection
		System.out.println("=====> SamsungTV(2) 객체 생성...."); 
		this.speaker=speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) { 
		System.out.println("=====> SamsungTV(3) 객체 생성...."); 
		this.speaker=speaker;
		this.price=price;
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다. (가격 : "+this.price+")");
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	
	@Override
	public void volumeUp() {
		speaker=new AppleSpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV --- 소리 올린다.");
	}
	
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		speaker=new AppleSpeaker();
		//System.out.println("SamsungTV --- 소리 내린다.");
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("====>setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("====>setPrice() 호출");
		this.price = price;
	}
	
}
