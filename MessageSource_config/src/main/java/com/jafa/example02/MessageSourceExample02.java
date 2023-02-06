package com.jafa.example02;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig02;

// 자바 설정으로 MessageSource빈 사용 
public class MessageSourceExample02 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig02.class);
		
		String message_default = ctx.getMessage("myword.hello", null, Locale.getDefault()); // ko_KR
		String message_en = ctx.getMessage("myword.hello", null, Locale.ENGLISH); // en
		String welcome = ctx.getMessage("welcome", new String[] {"임꺽정","우리집"}, Locale.getDefault());

		System.out.println(message_default);
		System.out.println(message_en);
		System.out.println(welcome);
	}
}
