package com.jafa.cofig.mybatis;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.jafa.domain.BoardVO;
import com.jafa.domain.MemberVO;

@Configuration
public class MybatisConfig {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(
				new ClassPathResource("mybatis/mappers/BoardDaoMapper.xml"), 
				new ClassPathResource("mybatis/mappers/MemberDaoMapper.xml"));
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
