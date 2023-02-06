package com.jafa.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachVO {
	Long attachNo;
	Long bno; 
	String filePath; // 파일 경로
	String fileName; // 파일 이름
	FileType fileType; 
}
