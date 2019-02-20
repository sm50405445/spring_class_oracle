package polymorphism;

public class LgTv implements Tv{

	public void turnOn() {
		System.out.println("LGTV 키기");
	}
	
	public void turnOff() {
		System.out.println("LGTV 끄기");
	}
	
	public void soundUp() {
		System.out.println("LGTV 볼륨업");
	}
	
	public void soundOff() {
		System.out.println("LGTV 볼륨다운");
	}
	
}
