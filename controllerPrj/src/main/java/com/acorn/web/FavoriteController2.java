package com.acorn.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FavoriteController2 {
	
	@GetMapping("/hi")   //요청
	public void method1( ) {			
		//모델
		//view  : 요청의 이름을 view로 반환 ("hi" view 응답)
	}
	
	@GetMapping("/hi2")
	public String method2( Model  model) {
		//모델
		//뷰정보 : String 리턴값
		model.addAttribute("data", "spring hi~~~");		
		return "view"; // view 이름으로 ("view" 이름의 뷰가 응답된다)
	}
	
	@GetMapping("/hi3")
	public ModelAndView method3() {
		//모델
		//뷰정보 : String 리턴값 
		ModelAndView mv = new ModelAndView(); // 모델 정보와 view 정보를 
		mv.setViewName("view3"); // 뷰정보
		mv.addObject("data", "spring hi~~~"); // 모델 정보 
		return mv;
	}
	
}
