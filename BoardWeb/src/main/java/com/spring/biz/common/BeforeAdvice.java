package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println(
		"[사전처리]"+method+"()메서드 Args정보: "+args[0].toString()+" 비즈니스 로직 수행 전 동작");
	}
}
