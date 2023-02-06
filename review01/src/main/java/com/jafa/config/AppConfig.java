package com.jafa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jafa.spring.BoardDao;
import com.jafa.spring.BoardService;

@Configuration
public class AppConfig {
	
	@Autowired
	private BoardDao boardDao;
	
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService(); 
		boardService.setBoardDao(boardDao);
		return boardService;
	}
}
