package polymorphism;

public class SamsungTv implements Tv{

	private Speaker speaker;
	private int price;
	
	public SamsungTv() {
		System.out.println("samsungTv 객체 생성");
	}
	
	public SamsungTv(Speaker speaker) {
		System.out.println("samsungTv(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTv(Speaker speaker, int price) {
		System.out.println("samsungTv(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker 메서드 생성");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice 메서드 생성");
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
		speaker.volumeUp();
	}
	
	public void soundOff() {
		speaker.volumeDown();
	}
	
	public void initMethod() {
		System.out.println("method 실행 전");
	}
	
	public void destroyMethod() {
		System.out.println("삼성TV 객체소멸");
	}
	
}