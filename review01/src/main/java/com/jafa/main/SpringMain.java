package com.jafa.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jafa.config.AppConfig;
import com.jafa.config.AppContext;
import com.jafa.spring.BoardService;
import com.jafa.spring.MemberService;

public class SpringMain {
	public static void main(String[] args) {
//		Assembler assembler = new Assembler(); 
//		MemberService service = assembler.getMemberService();
		
//		AnnotationConfigApplicationContext ctx =
//				new AnnotationConfigApplicationContext(AppContext.class);

//		GenericXmlApplicationContext ctx =  
//				new GenericXmlApplicationContext("classpath:appContext.xml");
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		
		MemberService service = ctx.getBean("memberService",MemberService.class);
		service.register();
		
//		BoardService boardService = ctx.getBean(BoardService.class);
//		boardService.list();
		
	}
}
