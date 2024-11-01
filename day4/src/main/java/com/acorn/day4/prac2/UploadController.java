package com.acorn.day4.prac2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	
	
	@GetMapping("/uploadex")
	public String upload() {	
		
		return "uploadform";   //화면이 응답
	}
	
	
	@PostMapping("/uploadex" )
	public String upload2(  String goodsName  ,  MultipartFile   file  , Model model ) throws IllegalStateException, IOException {	
		
		System.out.println( goodsName);
		System.out.println( file.getOriginalFilename());
		String name  = file.getOriginalFilename();
		
		//저장할 이름 (겹치지 않는 이름 필요함  )		
		 String saveName = UUID.randomUUID().toString();  //udifdfd121541516.jpg
		 System.out.println( saveName);
		 
		 int index  =name.lastIndexOf(".");
		 String ext   = name.substring(index+1);  // 해당위치에서 전부가져옴		
		 System.out.println( "확장자" + ext);		 
		 saveName=  saveName + "." + ext;
		 
		 System.out.println( saveName); 
		 //상품이름, 상품이미지_원본이름, 상품이미지_저장이름		 
		 System.out.println("서비스를 통해서 저장한다"); 
			
		 //1) 서버측 공간 저장하기 ( 업로드)
		//서버측 공간에 저장( 업로드)
		String fullpath  = "c:\\test\\upload\\"+ saveName;		
		file.transferTo(new File(fullpath));     // cute.jpg
		
		//2) 서비스-dao 데이터베이스에 저장하기
		
		// 파일 업로드가 이루어 진다
		
		model.addAttribute("imgname" ,saveName );
		return "uploadok";
	}
	
	
	
	// 업로드한 이미지가 사용자에게 보여주기  (서비스)
	// 이미지를 보여주기 위한  getMapping  만들기  
	@ResponseBody
	@RequestMapping( value="/images2/{imgName:.*}"  , method =RequestMethod.GET)
	public  Resource image( @PathVariable String imgName) throws MalformedURLException {
		System.out.println(imgName);
		UrlResource r  = new UrlResource("file:c:\\test\\upload\\"+imgName); 
		return  r; 
	}
	
}
