package kr.co.spring;

import org.springframework.stereotype.Component;

@Component
public class BoardDao {
	
	public void insert() {
		System.out.println("게시글 등록");
	}
}
