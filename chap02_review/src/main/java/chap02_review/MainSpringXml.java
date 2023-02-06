package chap02_review;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainSpringXml {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		MemberDao dao = ctx.getBean("memberDao",MemberDao.class);
		System.out.println(dao);
		dao.greeting("Hi?");
	}
}
