package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTv implements Tv{

	@Autowired
	@Qualifier("apple")
	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTv() {
		System.out.println("LG TV 객체 생성");
	}
	
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
