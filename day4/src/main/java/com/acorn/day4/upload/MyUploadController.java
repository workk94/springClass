package com.acorn.day4.upload;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

 
@Controller
public class MyUploadController {
	
	
	String fileDir="c:\\test\\upload\\";    //   c:/test/upload/ ;

	//get 파일업로드 화면
	
	@RequestMapping( value="/upload")
	public String uploadForm() {	
		return  "form";
	}
	
	
	//post 파일업로드 구현		
	@RequestMapping( value="/upload" , method = RequestMethod.POST)
	public String  upload( @RequestParam String goodsName,  @RequestParam MultipartFile  file , Model model ) throws IllegalStateException, IOException {				
		
		System.out.println( goodsName);
		String fileRealName  = file.getOriginalFilename();
		String fullPath  =   fileDir  + fileRealName;
		file.transferTo(new File(fullPath));		
		model.addAttribute("fileName", fileRealName);
		return  "ok";		
	}
	 	
	
	//업로드된 이미지 보여기주기	
	@ResponseBody
	@RequestMapping( value="/images/{fileName:.*}" , method=RequestMethod.GET)
	public  Resource  image(   @PathVariable String  fileName ) throws MalformedURLException {		 
		System.out.println(  fileName);		
		return new UrlResource("file:c:\\test\\upload\\"+ fileName);  // 서버의 자원을 반환할 때 사용( 이미지, 파일)
		
	}
	
}

/*
file: 프로토콜이 명시되므로, 이 경로를 로컬 파일 시스템에서 찾음
생성된 UrlResource 객체는 지정된 파일에 대한 접근을 제공함
 */