package com.jafa.example03;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class LoginResult implements MessageSourceAware{
	
	MessageSource messageSource; 
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public void successLoing(String username) {
		String message = messageSource.getMessage("login.success", new String[] {"홍길동"},Locale.getDefault());
		System.out.println(message);
	}
	
	public void failLogin() {
		String message = messageSource.getMessage("login.fail", null,Locale.getDefault());
		System.out.println(message);
	}

	
}
