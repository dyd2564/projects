package com.jafa.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jafa.dao.SampleDao;
import com.jafa.domain.SampleVO;

// @PathVariable
@Controller
@RequestMapping("/sample03") 
public class SampleController03 {
	
	@Autowired
	SampleDao sampleDao; 
	
	// 파라미터 이름과 동일한 이름을 갖는 경로 변수사용 
	// 요청경로가 /sample03/member/lee일 경우 
	// 파라미터 memberId에 lee값이 전달된다.
	// 파라미터로 선언된 memberId는 뷰페이지에서 이름을 memberId로 사용할 수 있음
	@GetMapping("/member/{memberId}")
	public String myPage1(@PathVariable String memberId) {
		System.out.println(memberId);
		return "sample03/detail01";
	}
	
	// 필수여부지정 : required속성, 기본값 true
	// 값을 전달하지 않을 경우 여러개 경로를 지정함
	@GetMapping(value = {"/member/{memberId}", "/member"})
	public String myPage2(@PathVariable(required = false) String memberId) {
		System.out.println(memberId);
		return "sample03/detail01";
	}
	
	// 파라미터 이름와 경로변수가 다를 경우 
	// value속성으로 경로변수를 지정할 수 있음 
	// value만 단독으로 사용할 경우 생략 가능 @PathVariable("memberId")
	// 뷰에서 경로변수와 동일한 이름을 사용함 (memberId)
	@GetMapping("/member3/{memberId}")
	public String myPage3(@PathVariable(value = "memberId") String userId) {
		System.out.println(userId);
		return "sample03/detail03";
	}
	
	// 하나 이상의 경로 변수를 사용할 수 있다. 
	@GetMapping("/member4/{memberId}/{mno}")
	public String myPage4(@PathVariable String memberId,@PathVariable Long mno) {
		System.out.println(memberId);
		System.out.println(mno);
		return "sample03/detail04";
	}
}
