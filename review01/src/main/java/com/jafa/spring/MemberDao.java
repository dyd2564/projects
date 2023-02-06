package com.jafa.spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	public void insert() {
		System.out.println("MemberDao");
	}
}
