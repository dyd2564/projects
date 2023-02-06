package com.jafa.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.jafa.spring.BoardService;
import com.jafa.spring.MemberService;

public class SpringXmlMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(
					"classpath:appContext.xml"); 
		MemberService service = ctx.getBean(MemberService.class);
		service.register();
		
		BoardService boardService = ctx.getBean(BoardService.class);
		boardService.list();
	}
}
