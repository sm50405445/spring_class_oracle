package com.spring.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.user.impl.UserServiceImpl;

public class UserServiceClient {

	public static void main(String[] args) {
		
		//1 spring 구동
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		//2 컨테이너로부터 userserviceimpl 구현
		UserServiceImpl userService = ctx.getBean(UserServiceImpl.class);
		
		//3
		UserVO vo = new UserVO();
		vo.setId("test2");
		vo.setPassword("1234");
		vo.setRole("Admin");
		
		UserVO user = userService.getUser(vo);
		if(user!=null){
			System.out.println(user.getName()+"님 환영합니다.");
		}else {
			System.out.println("회원정보가 없습니다.");
		}
		
		ctx.close();
		
	}
}
