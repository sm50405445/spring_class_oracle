package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Tvuser {

	public static void main(String[] args) {
		
		// 1.스프링 컨테이너를 구동한다
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		AbstractApplicationContext
			- 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하는 컨테이너이다.
		GenericXmlApplicationContext
			- 웹기반의 스프링 애플리케이션 개발할 때 사용하는 컨테이너
			
		*/
		// 2.스프링 컨테이너로부터 필요한 객체를 요청 lookup = 요청
		Tv tv = (Tv)ctx.getBean("tv");
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundOff();
		
		
		Tv tv2 = (Tv)ctx.getBean("tv2");
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundOff();
		
		
		// 3.컨테이너를 종료한다
		ctx.close();
		
		
		
		
		/*
		  BeanFactory factory = new BeanFactory(); Tv tv =
		  (Tv)factory.getBean(args[0]);
		*/
	}
}
