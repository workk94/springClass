package com.acorn.day4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserMainController {

	
	//main 요청시  main화면이 나옴 
	//화면전환없이  사용자 정보를 변경, 삭제, 추가해 보자
	
	@RequestMapping(value="/main")
	public String  home() {
		return "main";		
	}
	
	
	 
	 
	
}
