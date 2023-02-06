package com.jafa.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.BoardVO;
import com.jafa.domain.BoardVO.FileType;
import com.jafa.repository.BoardRepository;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 목록 
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", boardRepository.list());
		return "board/list";
	}
	
	// 상세
	@GetMapping("/detail")
	public String detail(Model model,Long bno) {
		model.addAttribute("b", boardRepository.detail(bno));
		return "board/detail";
	}
	
	// 글쓰기폼
	@GetMapping("/write")
	public void writeForm() {}
	
	// 글쓰기 처리
	@PostMapping("/write")
	public String write(BoardVO vo, 
		 @RequestParam("attachFile") MultipartFile multipartFile, RedirectAttributes rttr) {
		
		if(!multipartFile.isEmpty()) { // 첨부파일이 있을 때 
			String fileName = multipartFile.getOriginalFilename(); // 첨부파일 이름
			vo.setFileName(fileName); 
			// 파일타입 결정 : IMAGE, OHTER
			if(multipartFile.getContentType().startsWith("image")) { // 이미지 파일일 때
				vo.setFileType(FileType.IMAGE);
			} else { // 이미지 파일이 아닐 때 
				vo.setFileType(FileType.OHTER);
			}
			boardRepository.write(vo); // 데이터베이스에 저장 
			
			// c:/file01_repo/1/코끼리.png
			// 업로드
			File uploadPath = new File("c:/file01_repo/"+vo.getBno());
			if(!uploadPath.exists()) { // 업로드 패스 생성
				uploadPath.mkdirs();
			}
			// 업로드 파일경로 지정 
			File uploadFile = new File(uploadPath,fileName);
			try {
				multipartFile.transferTo(uploadFile); // 파일 업로드 
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} 
			
		} else { // 첨부파일이 없을때 
			boardRepository.write(vo);
		}
		return "redirect:/board/list";
	}
	
	// 삭제
	@PostMapping("/remove")
	public String remove(Long bno) {
		BoardVO vo = boardRepository.detail(bno); // 게시물정보조회 
		if(vo.getFileName()!=null) {
			// 파일 삭제 
			File file = new File("c:/file01_repo/"+bno,vo.getFileName());
			File forlder = new File("c:/file01_repo/"+bno);
			file.delete(); // 파일삭제
			forlder.delete(); // 폴더삭제
		}
		boardRepository.remove(bno); // 게시물삭제 
		return "redirect:/board/list";
	}
	
	// 수정폼
	@GetMapping("/modify")
	public void modifyForm(Long bno, Model model) {
		BoardVO vo = boardRepository.detail(bno);
		model.addAttribute("b", vo);
	}
	
	// 수정처리 
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr,
			@RequestParam(defaultValue = "false") Boolean delChk,
			@RequestParam("attachFile") MultipartFile multipartFile) {
		//
		if(delChk) {
			// 파일 삭제 및 내용 변경
			// 파일삭제
			BoardVO detail = boardRepository.detail(vo.getBno());
			File file = new File("c:/file01_repo/"+detail.getBno()+"/"+detail.getFileName());
			File folder = new File("c:/file01_repo/"+detail.getBno());
			file.delete();
			folder.delete();
			// modify호출
			boardRepository.modify(vo);
		} else {
			if(!multipartFile.isEmpty()) { // 이미지 및 내용 변경  

				// 기존 파일 삭제
				BoardVO detail = boardRepository.detail(vo.getBno());
				File file = new File("c:/file01_repo/"+detail.getBno()+"/"+detail.getFileName());
				file.delete();
				
				// 새로운 파일 업로드 
				String fileName = multipartFile.getOriginalFilename(); // 첨부파일 이름
				vo.setFileName(fileName); 
				// 파일타입 결정 : IMAGE, OHTER
				if(multipartFile.getContentType().startsWith("image")) { // 이미지 파일일 때
					vo.setFileType(FileType.IMAGE);
				} else { // 이미지 파일이 아닐 때 
					vo.setFileType(FileType.OHTER);
				}
				
				File uploadPath = new File("c:/file01_repo/"+vo.getBno());
				if(!uploadPath.exists()) { // 업로드 패스 생성
					uploadPath.mkdirs();
				}
				// 업로드 파일경로 지정 
				File uploadFile = new File(uploadPath,fileName);
				try {
					multipartFile.transferTo(uploadFile); // 파일 업로드 
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
				boardRepository.modify(vo);
			
			//modify호출
			} else { // 내용만 변경
				// modifyOnlyContent 호출
				boardRepository.modifyOnlyContent(vo);
			}
		}
		return "redirect:/board/list";
	}
}
