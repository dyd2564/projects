package spring;

public class ChangePasswordService {
	
	private MemberDao memberDao;

	// 세터(수정자) 주입 
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email); 
		if(member==null) { // 회원을 찾을 수 없다면
			throw new MemberNotFoundException(); // '회원찾을수없음' 예외 발생
		}
		// 회원이 있다면 
		member.changePassword(oldPwd,newPwd); // 비밀번호 변경
		memberDao.update(member); // 업데이트 
	}
	
	
}
