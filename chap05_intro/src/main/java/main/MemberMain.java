package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jafa.spring.MemberService;

import config.AppContext;

public class MemberMain {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		MemberService bean = ctx.getBean(MemberService.class);
		bean.register();
		
	}
}
