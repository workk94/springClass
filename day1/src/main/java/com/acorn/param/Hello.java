package com.acorn.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	
	//매서드단위의 매핑	
	@RequestMapping("/acorn1")
	public void hi() {		
		
		// 반환타입이 없는 경우 
		// 매핑의 이름을   view로 사용함 
	}
	
	
	@RequestMapping("/acorn2")
	public String hi2() {		
		return "acornview";   // view이름
	}
	
	
	@RequestMapping("/acorn3")    //요청  , view 이름 : acorn3
	public  void hi3( Model  model) {
		String result ="spring 조아 ";
		model.addAttribute("data", result);
		
	}
	

}
