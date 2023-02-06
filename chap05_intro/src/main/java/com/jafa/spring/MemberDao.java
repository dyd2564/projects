package com.jafa.spring;

import org.springframework.stereotype.Component;

@Component("memberDao1")
public class MemberDao {
	
	public void insert() {
		System.out.println("memberDao1");
		System.out.println("회원가입");
	}
}