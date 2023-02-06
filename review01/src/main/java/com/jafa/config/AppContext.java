package com.jafa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.jafa.main.SpringMain;
import com.jafa.spring.BoardDao;
import com.jafa.spring.MemberDao;

@Configuration
@Import(value = {AppConfig.class})
@ComponentScan(basePackageClasses = {MemberDao.class})
public class AppContext {


	@Bean
	public BoardDao boardDao() {
		return new BoardDao(); 
	}
}
