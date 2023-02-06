package com.jafa.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	
	private MemberDao memberDao; 
	
	public MemberService() {}
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void  register() {
		System.out.println("MemberService: register()");
		memberDao.insert(); 
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
