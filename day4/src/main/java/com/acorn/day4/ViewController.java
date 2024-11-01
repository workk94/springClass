package com.acorn.day4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	//view응답하는 반환  type
	// void, String ,  ModelAndView
	
	@RequestMapping("/view1")
	public void  method1() {
		// 매핑의 이름을   view로 반환한다
	}	
	
	@RequestMapping("/view2")
	public String  method2() {
		// 매핑의 이름을   view로 반환한다
		return "viewName";
	}
	
	
	@RequestMapping("/view3")
	public ModelAndView  method3() {
		// 매핑의 이름을   view로 반환한다
		ModelAndView   mv = new ModelAndView();
		mv.setViewName("viewName2");		
		return mv;
	}
}
