package chap02_review;

public class MemberService {
	
	private MemberDao memberDao;
	
	public void greetingService(String greet) {
		memberDao.greeting(greet);
	}
}
