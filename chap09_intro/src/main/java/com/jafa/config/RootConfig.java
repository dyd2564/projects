package com.jafa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jafa.dao.BoardDao;

@Configuration
public class RootConfig {
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao(); 
	}
}
