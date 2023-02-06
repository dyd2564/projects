package com.jafa.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.cofig.RootConfig;
import com.jafa.cofig.ServletConfig;
import com.jafa.cofig.mybatis.MybatisConfig3;
import com.jafa.dao.BookRepository;
import com.jafa.domain.BookVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,ServletConfig.class,MybatisConfig3.class })
@WebAppConfiguration
public class Config3 {
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void test() {
		BookVO vo = BookVO.builder()
				.title("스프링5.0")
				.writer("이일민").build();
		bookRepository.addBook(vo);
		System.out.println(vo.getId());
	}
}
