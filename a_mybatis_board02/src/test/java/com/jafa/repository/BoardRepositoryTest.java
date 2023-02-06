package com.jafa.repository;

import static org.junit.Assert.*;

import java.util.List;

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
	public void test() {
		List<BoardVO> list = repository.list();
	}
	
	@Test
	@Ignore
	public void test2() {
		repository.detail(1L);
	}
	
	@Test
	@Ignore
	public void test3() {
		List<BoardVO> list = repository.list2();
	}
	
	@Test
	@Ignore
	public void test4() {
		repository.detail2(1L);
	}
	
	@Test
	public void test5() {
		BoardVO vo = BoardVO.builder()
				.title("제목01")
				.content("내용01")
				.writer("글쓴이")
				.build();
		repository.save(vo);
		System.out.println("vo.getBno() : "+vo.getBno());
	}
}
