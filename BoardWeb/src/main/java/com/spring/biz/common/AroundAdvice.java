package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint pjp, JoinPoint jp) throws Throwable{
		
		/* System.out.println("[BEFORE]: 비즈니스 로직 수행전 처리할 내용"); */
		String method = jp.getSignature().getName();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object returnObj = pjp.proceed();
		stopwatch.stop();
		
		/* System.out.println("[AFTER]: 비즈니스 메서드 수행후 처리"); */
		System.out.println(method);
		return returnObj;
		
	}
}
