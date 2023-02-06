package com.jafa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.dao.BoardDao;
import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;
import com.jafa.domain.PageMarker;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardDao dao; 
	
	@GetMapping("/list")
	public String list(Criteria criteria, Model model) {
		List<BoardVO> list = dao.list(criteria);
		PageMarker pageMarker = new PageMarker(criteria, dao.totalCount());
		model.addAttribute("list", list);
		model.addAttribute("p", pageMarker);
		return "/board/list";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam("bnumber") Long bno, Model model) {
		try {
			BoardVO detail = dao.detail(bno);
			System.out.println(detail);
			model.addAttribute("board", detail);
		} catch (EmptyResultDataAccessException e) {
			return "/error/notFoundArticle";
		}
		return "/board/detail";
	}
}
