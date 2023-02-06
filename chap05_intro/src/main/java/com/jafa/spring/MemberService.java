package com.jafa.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberService {
	
	private MemberDao mDao; 
	
	@Autowired
	public void setMemberDao(MemberDao mDao) {
		this.mDao = mDao;
	}

	public void register() {
		mDao.insert();
	}
}
