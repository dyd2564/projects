package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jafa.dao.SampleDao;
import com.jafa.domain.SampleVO;

// @@RequestMapping, @GetMapping, @PostMapping, 커맨드객체
@Controller
@RequestMapping("/sample02") // 클래스단위에 @RequestMapping 적용
// 메서드에서 지정한 경로와 결합하여 동작 
public class SampleController02 {
	
	@Autowired
	SampleDao sampleDao; 
	
	// GET방식 method 속성 생략가능
	// value속성을 단독으로 사용할시 속성명을 생략할 수 있음
	@RequestMapping(value = "/list1", method = RequestMethod.GET)
	public String list1() {
		return "sample02/sampleList01";
	}
	
	// 배열을 사용하면 여러 경로를 지정할 수 있음 
	@RequestMapping(value = {"/list2", "/list"})
	public String list2() {
		return "sample02/sampleList02";
	}
	
	@GetMapping("/sampleForm")
	// @RequestMapping(value = "/sampleForm", method = RequestMethod.GET)
	public String sampleForm() {
		return "sample02/sampleForm";
	}
	
	// @PostMapping("/sampleProceed")
	@RequestMapping(value = "/sampleProceed", method = RequestMethod.POST)
	public String list4(@ModelAttribute("svo") SampleVO vo) {
		// 컨트롤러 메소드에 사용된 참조타입 파라미터를 커맨드 객체라함(String, Wrapper클래스 제외)
		// 커맨드 객체는 Model에 데이터를 등록하지 않고 뷰에서 사용할 수 있다. 
		// 이 때 뷰페이지에서 사용할 이름은 sampleVO 이다. (타입에서 첫글자를 소문자로 변경한 이름)
		// 뷰에서 사용할 이름을 변경하려면 @ModelAttribut 사용
		// 커맨드 개체를 사용하려면 기본생성자가 반드시 있어야함 
		System.out.println(vo);
		return "sample02/sampleResult";
	}
}
