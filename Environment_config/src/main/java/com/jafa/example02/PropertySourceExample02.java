package com.jafa.example02;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

// Environment에 PropertySource 추가하기 
public class PropertySourceExample02 {
	
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = 
						new AnnotationConfigApplicationContext();
		
		ConfigurableEnvironment environment = ctx.getEnvironment();
		
		// PropertySource를 등록하는 메소드 제공 
		MutablePropertySources propertySources = environment.getPropertySources();
		
		// 프로퍼티 파일을 등록 
		// 우선순위 addFirst > addLast
		propertySources.addFirst(new ResourcePropertySource("classpath:/example02/oracle.properties"));
		propertySources.addLast(new ResourcePropertySource("classpath:/example02/mysql.properties"));
		
		String driver = environment.getProperty("db.driver");
		String url = environment.getProperty("db.url");
		String username = environment.getProperty("db.username");
		String password = environment.getProperty("db.password");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
}
