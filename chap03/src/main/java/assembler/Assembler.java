package assembler;

import lombok.Getter;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	// 객체생성 및 관계설정
	public Assembler() {
		memberDao = new MemberDao(); // MemberDao객체생성
		regSvc = new MemberRegisterService(memberDao); // MemberRegisterService객체생성, 생성자주입
		pwdSvc = new ChangePasswordService(); // ChangePasswordService객체 생성
		pwdSvc.setMemberDao(memberDao); // 세터주입
	}
	
	// 빈 검색기능
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
}
