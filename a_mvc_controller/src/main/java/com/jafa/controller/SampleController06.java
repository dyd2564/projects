package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.StudentVO;

import oracle.jdbc.proxy.annotation.Post;

// 커맨드 객체(StudentVO)의 중첩객체(ReportCard) 프로퍼티 처리 
@Controller
@RequestMapping("/sample06")
public class SampleController06 {
	
	@GetMapping("/report")
	public String reportForm() {
		return "/sample06/reportForm";
	}
	
	// StudentVO, ReportVO
	@PostMapping("/report")
	public String report(StudentVO vo) {
		System.out.println(vo);
		return "/sample06/reportResult";
	}
}
