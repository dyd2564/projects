package chap02_review;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		MemberDao dao = ctx.getBean("memberDao2",MemberDao.class);
		dao.greeting("Hello?");
		MemberDao dao2 = ctx.getBean("memberDao",MemberDao.class);
		System.out.println(dao);
		System.out.println(dao2);
		System.out.println(dao==dao2);
	}
}
