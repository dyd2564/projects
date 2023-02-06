# 프로젝트 : b_mvc_ex_mybatis
	- 마이바티스설정01.sql
	- 데이터베이스 테이블 생성 및 테스트 데이터 추가 
	
## mybatis Spring 모듈 추가 
	- pom.xml
		mybatis
		mybatis-spring
	
## SqlSessionFactoryBean 설정 
	- classpath:spring-config/mybatis/mybatis-base.xml
	- 스프링과 마이바티스를 연동 
	- SqlSession 객체 생성 : CRUD 작업 수행 
		- dataSource : 데이터소스 빈 전달 
		- mapperLocation : 쿼리문을 담은 매퍼 파일 전달 
		- typeAliases : 매퍼파일에서 완전한 클래스 이름 대신 사용할 별칭 
			- MemberVO 클래스에서 @Alias("member") 지정
			- 지정하지 않으면 기본값으로 memberVO 이름을 사용함 

	
## SqlSessionTemplate 설정 
	- classpath:spring-config/mybatis/mybatis-base.xml
		- SqlSessionFactoryBean 생성자 주입 
		
## Mybatis를 이용한 DAO 구현 
	- 설정파일 : mybatis-base.xml, mybatis-config1.xml
	- MemberDao, BoardDao 인터페이스 생성 
	- MemberDaoImpl , BoardDaoImpl클래스 생성
		- MemberDaoImpl : 스프링 빈 직접 등록 , SqlSessionTemplate 사용
		- BoardDaoImpl : 애노테이션으로 스프링빈 등록, SqlSession 사용
	- MemberVO, BoardVO 클래스 생성 
	- 매퍼 파일 생성 
		- classpath:mybatis/mappers/memberMapper.xml
		- classpath:mybatis/mappers/boardMapper.xml
	- 테스트 케이스 : com.jafa.mybatis.Config1
	
## Mapper파일 설정 : 앤트 매핑 스타일 
	- 설정파일 : mybatis-base2.xml, mybatis-config2.xml
	- SqlSessionFactoryBean mapperLocations 속성 
		- classpath:mybatis/mappers/**/*Mapper.xml
		- ** 0개 이상의 디렉토리 
		- Mapper.xml으로 끝나는 모든 파일

## 자동매퍼 생성 기능 
	- 설정파일 : mybatis-base2.xml, mybatis-config3.xml
	- BookVO 클래스 생성 
	- BookRepository, BoardDao 인터페이스 생성 
	- mybatis-config3.xml
		- MapperFactoryBean 스프링빈으로 등록
			- mapperInterface 속성을 사용하여 인터페이스 주입 
			- 하나의 MapperFactoryBean에 대하여 하나의 인터페이스를 주입한다.
			- sqlSessionFacotry 빈 주입
	- 매퍼 파일 
		- bookMapper.xml : BookRepository에서 사용할 매퍼 
		- boardMapper.xml : BoardDao에서 사용할 매퍼 
	- 테스트 케이스 : Config3

## 스캔을 이용한 매퍼 검색 
	- 설정파일 : mybatis-base2.xml, mybatis-config4.xml
	- mybatis-spring:scan 태그 사용 
		- base-package 속성 : 설정 패키지 이하의 모든 매퍼 검색
	
	

	