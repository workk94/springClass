package com.acorn.day1prac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	enum Operator {
		ADD, SUB, MUL, DIV
	}

	// 두수를 입력 받아 사칙연산해서 제공
	@GetMapping("/calculator")
	public ModelAndView addTwoValue(@RequestParam(value = "num1", required = false, defaultValue = "1") Integer num1,
			@RequestParam(value = "op", required = false, defaultValue = "ADD") Operator operator,
			@RequestParam(value = "num2", required = false, defaultValue = "1") Integer num2) {

		System.out.println(num1);
		System.out.println(num2);
		System.out.println(operator);

		ModelAndView mv = new ModelAndView();

		int result = 0;

		switch (operator) {
		case ADD:
			result = num1 + num2;
			break;
		case SUB:
			result = num1 - num2;
			break;
		case MUL:
			result = num1 * num2;
			break;
		case DIV:
			result = (num2 != 0) ? num1 / num2 : 0;
			break;
		}

		mv.setViewName("calculate");
		mv.addObject("result", result);

		return mv;
	}
	
	
	// 3단 정보 제공
	@GetMapping("/dan3")
	public String gugu3Dan(Model model) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <=9; i++) {
			sb.append("3" + " * " +  i + " = " + i * 3);
			sb.append("<br>");
		}
		model.addAttribute("dan3", sb.toString());
		return "dan3";
	}
	
	
	// 원하는 단 제공하기 
	
	@GetMapping("/dan")
	public ModelAndView getGuguDan(@RequestParam(value="dan", required=false, defaultValue="2") Integer dan) {
		ModelAndView mv = new ModelAndView();
		
		String result = "";
		
		for(int i = 1; i <= 9; i++) {
			result += dan + " * " + i + " = " + i * dan;
			result += "<br>";
		}
		
		mv.setViewName("gugudan");
		mv.addObject("result", result);
		
		return mv;
			
		
	}

}
