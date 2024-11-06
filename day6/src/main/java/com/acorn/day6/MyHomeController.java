package com.acorn.day6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyHomeController {
	@GetMapping("/myhome")
	public String myhome () {
		return "myhome";
	}
}
