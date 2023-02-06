package com.jafa.example04;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig04;

public class MessageSourceExample04 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AppConfig04.class);
		
		// myword.hello, welcome
		String greeting = ctx.getMessage("myword.hello",null, Locale.getDefault());
		String welcome = ctx.getMessage("welcome", new String[] {"홍길동","우리집"},Locale.getDefault());
		System.out.println(greeting);
		System.out.println(welcome);
		
	}
}
