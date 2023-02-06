package com.jafa.example04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig04;

public class PropertySourceExample04 {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
				= new AnnotationConfigApplicationContext(AppConfig04.class);
		JdbcConnector bean = ctx.getBean(JdbcConnector.class);
		System.out.println(bean);
		
	}
}
