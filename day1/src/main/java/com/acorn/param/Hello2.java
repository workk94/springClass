package com.acorn.param;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello2 {
	
	@RequestMapping("/acorn4")
	public String hi(String id, String pw) {		
		System.out.println( id);		
		System.out.println( pw);
		
		return "hi";
	}
	
	
	@RequestMapping("/acorn5")
	public String h2(User user ) {  // 기본생성자 , setter이용	
		System.out.println( user.getId());
		System.out.println( user.getPw());
		return "hi2";
	}
	
	
	@RequestMapping("/acorn0")
	public String h3( HttpServletRequest request ) {		
		String id  = request.getParameter("id");
		String pw = request.getParameter("pw");		
		User user = new User();
		user.setId(id);
		user.setPw(pw);		
		 
		return "hi2";
	}
	
	
	@RequestMapping("/acorn6")
	public String hi4( Model model ) {  
		
		// Model  <- ArrayList<String> 과일이름 여러개 		
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("tomato");	
		
		model.addAttribute("fruit", list);	  
		return "hi4";
	}
	
	
	
}
