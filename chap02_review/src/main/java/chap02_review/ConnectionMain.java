package chap02_review;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConnectionMain {
	public static void main(String[] args) {
		ConnectionUtil util = new ConnectionUtil(); // 객체생성
		// Setter Injection
		util.setDriver("com.oracle.com");
		util.setUrl("localhost:8080");
		util.setUsername("scot");
		util.setPassword("tiger");
		util.connectionInfo();
		System.out.println();
		
		// 스프링컨테이너 활용
//		AnnotationConfigApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(AppContext.class);
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		ConnectionUtil bean = ctx.getBean("connectionUtil",ConnectionUtil.class);
		bean.connectionInfo();
	}
}
