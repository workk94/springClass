package com.acorn.cc;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SimpleUpload2 {	
	 private String fileDir ="c:\\test\\upload\\";  // 미리 폴더를 만들어야함	
	 
	 
	 
	 @GetMapping("/upload2")
	 public String uploadForm() {
		 return "form";
	 } 
	@PostMapping("/upload2")
 	public String upload( Goods2  goods , Model model) throws IllegalStateException, IOException {
	    	MultipartFile file = goods.getFile();
	    	System.out.println(file.getOriginalFilename());
		return "upload-ok";		
	}	
	
	
	//
	
	@ResponseBody	
    //@RequestMapping( value="/images/{fileName}" , method=RequestMethod.GET)
	@RequestMapping( value="/images2/{fileName:.*}" , method=RequestMethod.GET)
	public Resource imageDownload(@PathVariable String  fileName) throws MalformedURLException {		
		System.out.println( "fileName" + fileName);
		return new  UrlResource("file:c:\\test\\upload\\"+ fileName);
		
	}
	
	
	
	

}