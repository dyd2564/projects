package com.jafa.domain;

import lombok.Getter;

@Getter
public class PageMarker {
	private Criteria criteria;
	private int startPage; 
	private int endPage;
	private int tempEndPage; 
	private int totalCount;  
	
	private  int displayPageNum=10;
	private boolean prev; 
	private boolean next; 
	
	public PageMarker(Criteria criteria, int totalCount) {
		 this.criteria = criteria;
		 this.totalCount = totalCount; 
		 endPage = (int) Math.ceil(criteria.getPageNum()/(double)displayPageNum) * displayPageNum;
		 startPage = endPage - displayPageNum + 1;
		 tempEndPage = (int) Math.ceil(totalCount / (double)criteria.getAmount());
		 
		 prev = startPage != 1;
		 next = endPage < tempEndPage;  
		 
		 if(endPage > tempEndPage) endPage = tempEndPage;
	}
}
