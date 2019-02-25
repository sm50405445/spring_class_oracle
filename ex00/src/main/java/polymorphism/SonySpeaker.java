package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	
	
	@Override
	public void volumeUp() {
		System.out.println("볼륨업");
	}

	@Override
	public void volumeDown() {
		System.out.println("볼륨다운");
	}

	public SonySpeaker() {
		System.out.println("sonyspeaker 객체 생성");
	}
	
	
}
