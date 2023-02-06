package com.jafa.example01;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

// xml설정으로 MessageSource 사용
public class MessageSourceExample01 {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:appConfig01.xml");
		
		// greeting_ko_KR.properties -> greeting.properties
		String message_default = ctx.getMessage("myword.hello", null, Locale.getDefault()); // ko_KR
		System.out.println(message_default);
		
		// greeting_en.properties -> greeting.properties
		String message_en = ctx.getMessage("myword.hello", null, Locale.ENGLISH); // en
		System.out.println(message_en);
		
		String welcome = ctx.getMessage("welcome", new String[] {"홍길동","우리집"}, Locale.getDefault());
		System.out.println(welcome);
	}
}
