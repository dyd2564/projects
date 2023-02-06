package com.jafa.example05;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class JdbcConnector05 implements EnvironmentAware{

	// EnvironmentAware 인터페이스를 구현한 객체가 스프링빈으로 등록되면 
	// 스프링 컨테이너는 이 빈에 Environment객체를 주입해준다.
	private Environment environment; 
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment; 
	}
	
	public void JdbcInfo() {
		System.out.println("드라이버 : " + environment.getProperty("db.driver"));
		System.out.println("jdbcUrl : " + environment.getProperty("db.url"));
		System.out.println("사용자 계정 : " + environment.getProperty("db.username"));
		System.out.println("암호 : " + environment.getProperty("db.password"));
	}
}
