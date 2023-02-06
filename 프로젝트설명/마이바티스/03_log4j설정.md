## 프로젝트 준비 
	a_mvc_ex 복사 
	a_mvc_mybatis_config 생성

## 마이바티스 모듈 추가 
	mybatis
	mybatis-spring 2.x.x
	
## 마이바티스 설정 
	설정 파일 : com.jafa.config.RootConfig 
	@MapperScan 매퍼 인터페이스 패키지 설정 
	SqlSessionFactoryBean
		- DataSource빈 전달 
		- mapperLocations : classpath:mappers/**/*Mapper.xml
	SqlSessionTemplate
		- SqlSessionFactory : SqlSessionFactoryBean.getObejct()로부터 얻는다.
		- SqlSessionFactory빈 생성자 주입

## 매퍼 인터페이스 및 매퍼XML 작성 
	- 매퍼인터페이스 : com.jafa.repository.TestRepository
	- 매퍼 파일 : classpath:mappers/TestMapper.xml
	- 테스트 케이스 : com.jafa.mybatis.TestRepositoryTest

## log4j설정
	- 모듈 추가 
		log4j
		slf4j-log4j12
		jcl-over-slf4j
		spring-core : exclude(commons-logging)
	- 로그 설정 파일 : classpath:log4j.xml 
	
	