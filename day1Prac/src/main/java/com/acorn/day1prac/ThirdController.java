package com.acorn.day1prac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThirdController {

	// MVC : model - Service, DAO
	// Model이라는 객체 제공 - Model 객체에 데이터를 저장해서 view에서 사용
	@GetMapping("/mvc1")
	public String method1(Model model) { //

		//
		String data = "spring data 입니다";
		model.addAttribute("data", data);

		return "view1";
	}

	// 과일목록 model
	@GetMapping("/mvc2")
	public String method2(Model model) {

		List<String> list = new ArrayList<>();

		list.add("사과");
		list.add("딸기");
		list.add("배");

		model.addAttribute("list", list);

		return "view2";
	}

	// ModelAndView 객체 사용하기
	// ModelAndView 객체를 생성해서 model 정보와 view 정보를 저장
	@GetMapping("/mvc3")
	public ModelAndView method3() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view3");

		List<String> list = new ArrayList<>();
		
		// 음료모델 
		list.add("아메리카노");
		list.add("라떼");
		list.add("카푸치노");
		
		mv.addObject("list", list);
		
		
		return mv;
	}
}
