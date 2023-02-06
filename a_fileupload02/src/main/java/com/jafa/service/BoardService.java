package com.jafa.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jafa.common.FileUploadUtils;
import com.jafa.domain.AttachVO;
import com.jafa.domain.BoardVO;
import com.jafa.repository.AttachRepository;
import com.jafa.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	AttachRepository attachRepository;
	
	@Autowired
	FileUploadUtils fileUploadUtils;
	
	@Transactional
	public void write(BoardVO vo, MultipartFile[] multipartFiles) {
		// 게시물정보 저장 
		boardRepository.write(vo); // vo.getBno()값 생성 
		// 첨부파일 업로드
		// 첨부파일 정보 저장
		List<AttachVO> attachList = fileUploadUtils.getAttachVOAndUpload(vo.getBno(),multipartFiles);
		
		if(!attachList.isEmpty()) { // 첨부파일이 있으면 
			attachRepository.save(attachList); // 첨부파일 정보 저장 
			boardRepository.updateAttachFileCnt(vo.getBno()); // 첨부파일 개수 업데이트 
		}
	}

	public List<BoardVO> list() {
		return boardRepository.list();
	}

	public BoardVO detail(Long bno) {
		return boardRepository.get(bno);
	}

	public void remove(Long bno) {
		List<AttachVO> list = attachRepository.list(bno);
		if(!list.isEmpty()) { //첨부파일이 있다면
			// 모든 첨부파일 삭제 
			fileUploadUtils.deleteAllFile(bno);
		}
		boardRepository.remove(bno);
	}

	@Transactional
	public void modify(BoardVO vo, List<Long> delFileList, MultipartFile[] multipartFiles) {
		// 삭제할 파일 있다면 파일삭제, attach_file02 테이블 변경
		if(!delFileList.isEmpty()) { // 1,2,3
			for(Long attachNo : delFileList) {
				AttachVO attachVO = attachRepository.get(attachNo);
				new File(attachVO.getFilePath()).delete(); // 파일 삭제 
				attachRepository.remove(attachNo);
			}
		}
		// board_file02 테이블 변경 
		boardRepository.modify(vo);
		// 새로운 파일을 업로드해야하는 경우 
		List<AttachVO> attachList = fileUploadUtils.getAttachVOAndUpload(vo.getBno(),multipartFiles);
		if(!attachList.isEmpty()) { // 첨부파일이 있으면 
			attachRepository.save(attachList); // 첨부파일 정보 저장 
		}
		boardRepository.updateAttachFileCnt(vo.getBno()); // 첨부파일 개수 업데이트 
	}
}
