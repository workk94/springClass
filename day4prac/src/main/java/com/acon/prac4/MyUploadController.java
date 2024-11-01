package com.acon.prac4;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyUploadController {
	
	@Autowired
	ItemFormService service;
	
	private String path = "c:\\test\\upload\\";
	
	// 응답화면
	@RequestMapping(value ="/upload", method = RequestMethod.GET)
	public String  uploadForm() {
		return "form";
	}
	
	// 파일을 저장
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(ItemForm form, Model model) throws IllegalStateException, IOException {
		
		MultipartFile file = form.getFile();
		
		//업로드 파일 이름을 가져온다
		String originNm = form.getFile().getOriginalFilename();
		//임의로 파일의 새로운 이름을 생성한다
		String saveNm = UUID.randomUUID().toString();
		
		// 파일의 확장자를 새로운 이름에 추가한다 
		int index = originNm.lastIndexOf(".");
		String ext = originNm.substring(index+1);
		saveNm = saveNm + "." + ext;
		
		String fullpath = path + saveNm;
		System.out.println(fullpath);
		file.transferTo(new File(fullpath));
		
		service.save(form.getItemId(), originNm);
		
		model.addAttribute("imgname", saveNm);
		return "uploadok";
	}
	
	// 업로드한 이미지를 사용자에게 보여주기
	
	@ResponseBody
	@RequestMapping(value="images/{imgName:.*}", method=RequestMethod.GET)
	public Resource image(@PathVariable String imgName) throws MalformedURLException {
		System.out.println(imgName);
		UrlResource r = new UrlResource("file:c:\\test\\upload\\"+imgName);
		
		return r;
	}
	//public Resource get
}
