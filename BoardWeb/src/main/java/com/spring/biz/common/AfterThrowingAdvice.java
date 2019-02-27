package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public void exceptionLog(JoinPoint jp,Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println(method+"() 메서드 수행중 예외 발생!");
		
		if(exceptObj instanceof IllegalArgumentException) {
		System.out.println("부적합한 값이 입력 되었습니다.");	
		}else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다");	
		}else if(exceptObj instanceof Exception) {
			System.out.println("문제가 발생되었습니다.");	
		}
		
		/*System.out.println(
	"[예외처리]"+method+"()수행중 발생된 예외 메시지 "+exceptObj.getMessage());
	}*/
	}
}
