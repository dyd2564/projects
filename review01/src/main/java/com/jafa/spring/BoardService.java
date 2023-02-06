package com.jafa.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	private BoardDao boardDao;
	
	public void list() {
		System.out.println("BoardService : list()");
		boardDao.selectAll();
	}

	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	
}
