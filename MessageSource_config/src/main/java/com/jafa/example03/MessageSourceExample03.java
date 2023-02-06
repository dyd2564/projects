package com.jafa.example03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig03;

public class MessageSourceExample03 {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
					new AnnotationConfigApplicationContext(AppConfig03.class);
		LoginResult bean = ctx.getBean(LoginResult.class);
		bean.failLogin();
		bean.successLoing("홍길동");
	}
}
