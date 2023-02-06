package com.jafa.repository;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.BoardVO;

public class BoardRepositoryTest extends AppTest{

	@Autowired
	BoardRepository repository; 
	
	@Test
	@Ignore
	public void findAllTest() {
		repository.findAll();
	}
	
	@Test
	@Ignore
	public void detailTest() {
		repository.detail(1L);
	}
	
	@Test
	@Ignore
	public void saveTest() {
		repository.save(BoardVO.builder().title("제목추가")
			.content("내용추가").writer("이광협").build());
	}
	
	@Test
	public void updateTest() {
		repository.update(BoardVO.builder().title("제목 -- 수정")
				.content("내용 -- 수정").bno(5L).build());
	}
}
