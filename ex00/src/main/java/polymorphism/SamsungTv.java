package polymorphism;

public class SamsungTv implements Tv{

	private SonySpeaker speaker;
	int price;
	
	public SamsungTv(SonySpeaker speaker) {
		System.out.println("samsungTv 생성자 생성");
		this.speaker = speaker;
	}
	
	
	
	public SamsungTv(SonySpeaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}

	public void turnOn() {
		System.out.println("SamsungTV 키기");
		System.out.println(price);
	}
	
	public void turnOff() {
		System.out.println("SamsungTV 끄기");
	}
	
	public void soundUp() {
		speaker.soundUp();
	}
	
	public void soundOff() {
		speaker.soundOff();
	}
	
	public void initMethod() {
		System.out.println("method 실행 전");
	}
	
	public void destroyMethod() {
		System.out.println("삼성TV 객체소멸");
	}
	
}
