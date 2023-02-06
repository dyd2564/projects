## 프로젝트 준비 
	- a_mvc_mybatis_config 복사 
	- a_mybatis_board01
	- 마이바티스연습01.sql

## 도메인 모델 계층
	- BoardVO
	- RootConfig에서 TypeAliase 지정

## 데이터 액세스 계층 
	- 인터페이스 : com.jafa.repository.BoardRepository
	- 매퍼 파일 : classpath:mappes/BoardMapper.xml
	- 테스트 케이스 : com.jafa.repository.BoardRepositoryTest

## 서비스 계층 : 생략

## 프리젠테이션 계층
	- BoardController

	