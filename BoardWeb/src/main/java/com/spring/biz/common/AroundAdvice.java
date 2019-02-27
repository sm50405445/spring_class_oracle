package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		
		System.out.println("[BEFORE]: 비즈니스 로직 수행전 처리할 내용");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER]: 비즈니스 메서드 수행후 처리");
		
		return returnObj;
		
	}
}
