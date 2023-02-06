package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;

public interface BoardRepository {
	
	int getToalCount(Criteria criteria);
	
	List<BoardVO> list(Criteria criteria);
}
