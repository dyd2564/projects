package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.Criteria;
import com.jafa.domain.Pagination;
import com.jafa.repository.BoardRepository;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@Autowired
	BoardRepository repository;
	
	@GetMapping(value = {"/list","/list/{category}"})
	public String list(@ModelAttribute("cri") Criteria criteria, 
				Model model,
				@PathVariable(required = false) String category) { 
		criteria.setCategory(category);
		model.addAttribute("list", repository.list(criteria))
			.addAttribute("p", new Pagination(criteria, repository.getToalCount(criteria)));
		log.info(criteria);
		return "board/list";
	}
}
