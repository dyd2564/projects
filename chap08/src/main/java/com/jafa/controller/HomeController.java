package com.jafa.controller;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jafa.dao.BoardDao;

@Controller
public class HomeController {
	
	@Autowired
	BoardDao boardDao; 
	
	// localhost:8090/chap08/
	@GetMapping("/")
	public String home() {
		System.out.println(boardDao.list());
		return "index"; // /WEB-INF/views/index.jsp
	}
	
}
