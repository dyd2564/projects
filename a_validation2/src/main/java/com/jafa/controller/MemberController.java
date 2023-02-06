package com.jafa.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.MemberDTO;
import com.jafa.validation.MemberDTOValidator;

import lombok.extern.log4j.Log4j;

@RequestMapping("/member")
@Controller
@Log4j
public class MemberController {
	
	// 회원가입 폼
	@GetMapping("/join")
	public String joinView(MemberDTO memberDTO) {
		return "/member/join";
	}
	
	// 회원가입 처리
	@PostMapping("/join")
	public String join(@Valid MemberDTO memberDTO, Errors errors,  
			RedirectAttributes rttr) {
		if(errors.hasErrors()) {
			System.out.println("에러!!");
			return "/member/join";
		}
		log.info(memberDTO);
		return "redirect:/";
	}
}
