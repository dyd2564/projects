package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;

public interface BoardRepository {
	
	// Aliase 사용
	List<BoardVO> list();
	BoardVO detail(Long bno);
	
	// ResultMap 사용
	List<BoardVO> list2();
	BoardVO detail2(Long bno);
	
	// 자동 생성 키 받기
	void save(BoardVO vo);
}
