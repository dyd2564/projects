package com.jafa.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.cofig.RootConfig;
import com.jafa.cofig.ServletConfig;
import com.jafa.cofig.mybatis.MybatisConfig2;
import com.jafa.dao.BoardDao;
import com.jafa.dao.MemberDao;
import com.jafa.domain.BoardVO;
import com.jafa.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,ServletConfig.class,MybatisConfig2.class })
@WebAppConfiguration
public class Config2 {
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	MemberDao memberDao; 

	@Test
	public void test() {
		List<BoardVO> list = boardDao.findByWriter("관리자");
		System.out.println(list);
	}
	
	@Test
	public void test2() {
		MemberVO vo = memberDao.findByMno(1L);
		System.out.println(vo);
	}
}
