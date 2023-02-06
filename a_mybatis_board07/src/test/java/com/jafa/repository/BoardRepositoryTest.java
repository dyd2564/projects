package com.jafa.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.Criteria;

public class BoardRepositoryTest extends AppTest {

	@Autowired
	BoardRepository boardRepository;
	
	// 검색어 : X , 카테고리 : X
	@Test
	public void test() {
		Criteria criteria = new Criteria();
		boardRepository.getToalCount(criteria);
	}
	
	// 검색어 : O, 카테고리 : X
	@Test
	public void test2() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("스프링");
		boardRepository.getToalCount(criteria);
	}
	
	// 검색어 : O, 카테고리 : O
	@Test
	public void test3() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("스프링");
		criteria.setCategory("notice");
		boardRepository.getToalCount(criteria);
	}
	
	// 검색어 : X, 카테고리 : O
	@Test
	public void test4() {
		Criteria criteria = new Criteria();
		criteria.setCategory("notice");
		boardRepository.getToalCount(criteria);
	}

}
