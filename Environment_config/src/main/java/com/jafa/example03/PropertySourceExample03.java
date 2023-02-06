package com.jafa.example03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig03;

public class PropertySourceExample03 {
		
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
					new AnnotationConfigApplicationContext(AppConfig03.class); 
		
		JdbcConnector bean = ctx.getBean(JdbcConnector.class);
		System.out.println(bean);
	}
}
