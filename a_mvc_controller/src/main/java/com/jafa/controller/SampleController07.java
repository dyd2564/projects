package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.ApplicationFormVO;

// ApplicationFormVO
@Controller
@RequestMapping("/sample07")
public class SampleController07 {
	
	@GetMapping("/apply")
	public String applyForm() {
		return "sample07/applyForm";
	}
	
	@PostMapping("/apply")
	public String apply(@ModelAttribute("applyForm") ApplicationFormVO vo) {
		System.out.println(vo);
		return "sample07/applyResult";
	}
}
