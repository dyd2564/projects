package com.jafa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Criteria {
	private int pageNum; // 페이지번호
	private int amount = 10; // 한페이지에  게시물을 몇개나타낼건지?
	
	public Criteria() {
		this(1,10);
	}
}
