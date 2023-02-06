package com.jafa.spring;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	public void selectAll() {
		System.out.println("BoardDao : selectAll()");
	}
}
