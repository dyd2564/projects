package com.jafa.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jafa.domain.BoardVO;

public interface BoardRepository {
	
	List<BoardVO> boardList();

	void delAllSelected(@Param("bnoList") String[] bnoArray); 
}
