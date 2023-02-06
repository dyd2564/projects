package chap02_review;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberDao memberDao2() {
		return new MemberDao();
	}
	
	
	@Bean
	public ConnectionUtil connectionUtil() {
		ConnectionUtil util = new ConnectionUtil(); 
		util.setDriver("com.oracle.com");
		util.setUrl("localhost:8080");
		util.setUsername("scot");
		util.setPassword("tiger");
		return util;
	}
}
