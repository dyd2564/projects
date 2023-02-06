package com.jafa.cofig.mybatis;

import java.io.IOException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.jafa.dao.BookRepository;
import com.jafa.domain.BoardVO;
import com.jafa.domain.MemberVO;

@Configuration
public class MybatisConfig2 {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		// 앤트 매핑
		factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(
						"classpath:mybatis/mappers/**/*Mapper.xml"));
		factoryBean.setTypeAliases(BoardVO.class,MemberVO.class);
		return factoryBean; 
	}
	
	@Bean
	public SqlSessionTemplate sessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate 
			= new SqlSessionTemplate(sqlSessionFactory().getObject());
		return sqlSessionTemplate; 
	}
	
	
}
