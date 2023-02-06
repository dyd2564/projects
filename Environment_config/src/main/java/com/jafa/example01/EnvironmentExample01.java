package com.jafa.example01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class EnvironmentExample01 {
	
	// 시스템 프로퍼티 읽기
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
						= new AnnotationConfigApplicationContext();
		ConfigurableEnvironment environment = ctx.getEnvironment();
		
		String javaVersion = environment.getProperty("java.version");
		String javaHome = environment.getProperty("java.home");
		String osName = environment.getProperty("os.name");
		String pathSeperator = environment.getProperty("file.separator");
		System.out.println(javaVersion);
		System.out.println(javaHome);
		System.out.println(osName);
		System.out.println(pathSeperator);
	}
}
