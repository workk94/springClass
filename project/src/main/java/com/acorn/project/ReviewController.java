package com.acorn.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {
	
	
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String viewMain() {
		return "review";
	}
}
