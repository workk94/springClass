package com.acorn.day4.prac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {
	
	//@GetMapping("/goods")
	@RequestMapping(value="/goods", method=RequestMethod.GET)
	public String comment() {
		return "comment"; // view 
	}
}
