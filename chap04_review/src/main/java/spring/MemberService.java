package spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberService {
	
	
	MemberDao memberDao; 

	@Autowired
	public void setMemberDao(Optional<MemberDao> memberDaoOpt) {
		if(memberDaoOpt.isPresent()) {
			this.memberDao = memberDaoOpt.get();
		} else {
			this.memberDao = null; 
		}
	}

	public void register() {
		System.out.println("MemberService : 회원가입");
		memberDao.insert();
	}
}
