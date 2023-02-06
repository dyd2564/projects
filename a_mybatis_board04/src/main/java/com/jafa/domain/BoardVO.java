package com.jafa.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private Long bno; 
	private String title; 
	private String content;
	private String writer; 
	private String writeDate;
	
	private Category category;
}
