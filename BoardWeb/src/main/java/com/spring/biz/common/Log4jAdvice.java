package com.spring.biz.common;

public class Log4jAdvice {

	//공통으로 수행 할 로직
	public void printLogging() {
		System.out.println("[공통 로그-Log4j] 비즈니스 로직 수행 전 동작");
	}
}
