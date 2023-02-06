package com.jafa.controller.sample;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class SampleController {
	
	
	@GetMapping("sample/fileForm")
	public String fileForm() {
		return "sample/fileForm";
	}
	
	@PostMapping("sample/upload")
	public String fileUpload(String title,
			@RequestParam("attachFile") MultipartFile multipartFile) {
		log.info(title);
		log.info(multipartFile); // 파일이 없어도 null이 아님 !!
		log.info(multipartFile.isEmpty()); // 업로드 파일이 없으면 true
		log.info(multipartFile.getOriginalFilename()); // 파일이름
		log.info(multipartFile.getName()); // input 태그의 name속성
		log.info(multipartFile.getContentType()); // 파일 타입
		log.info(multipartFile.getSize()); // 파일크기
		
		File uploadFile = new File("c:/sample_repo",multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "redirect:/sample/fileForm";
	}
	
	// 요청 /sample/download?fileName=코끼리.png
	// 파일 다운로드 
	@GetMapping(value = "/sample/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(@RequestHeader("User-Agent") String userAgent, 
				String fileName) throws UnsupportedEncodingException{
		
		log.info(userAgent);
		Resource resource = new FileSystemResource("c:/sample_repo/"+fileName);
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		// 다운로드시 파일 이름 처리
		HttpHeaders headers = new HttpHeaders();
		String downFileName = new String(resource.getFilename().getBytes("UTF-8"), "ISO-8859-1");
		headers.add("Content-Disposition", "attach;fileName="+downFileName);
		
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
	// 삭제 
	// 요청 : /sample/delete?fileName=코끼리.png
	@GetMapping("/sample/delete")
	public String deleteFile(String fileName) {
		File file = new File("c:/sample_repo",fileName);
		if(file.exists()) { // 파일이 있으면
			file.delete();
		}
		return "sample/fileForm";
	}
	
	// /imgDisplay?fileName=코끼리.png
	// 이미지 파일 표시 
	@GetMapping("/sample/imgDisplay")
	@ResponseBody
	public ResponseEntity<byte[]> imgDisplay(String fileName) throws IOException{
		File file = new File("c:/sample_repo",fileName);
		if(!file.exists()) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		headers.add("Content-Type", fileNameMap.getContentTypeFor(fileName));
		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),headers, HttpStatus.OK);
	}
}
