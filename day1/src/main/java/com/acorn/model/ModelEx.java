package com.acorn.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelEx {
	
	//모델저장소 사용해 보기 
	 
	@RequestMapping("/m0")
	public String test0( HttpServletRequest request) {
		// Mvc2에서는 request 저장소 사용하였음 
		//request내의  저장소 사용하기
		request.setAttribute("message0", "model심기");		 
		return "model0";
	}
	
	
	
	@RequestMapping("/m1")
	public String test1(Model model) {		
		model.addAttribute("message", "스프링조아");
		return "model1";
	}
	
	
	@RequestMapping("/m2")
	public String test2(Model model) {		
		ArrayList<String> list = new ArrayList<String>();
		list.add("jsp");
		list.add("mvc2");
		list.add("spring ");		
		model.addAttribute("list", list);
		return "model2";
	}
	
	
	@RequestMapping("/m3")
	public String test3( Model model) {		
		ArrayList<User> list = new ArrayList<User>();
		list.add( new User("kim", "0000"));
		list.add( new User("lee", "1111"));
		list.add( new User("choi", "2222"));	
		model.addAttribute("list", list);
		return "model3";
	}

}
