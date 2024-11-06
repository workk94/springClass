package com.acorn.day6.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	
	
	// 홈화면
	@GetMapping("/cookiehome")
	public String home() {
		return "cookiehome";
	}
	
}
