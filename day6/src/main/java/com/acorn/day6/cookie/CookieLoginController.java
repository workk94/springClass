package com.acorn.day6.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookieLoginController {
	
	
	//로그인
	@GetMapping("/cookielogin")
	public String login1 () {
		return "cookielogin";
	}
	
	// 로그인 처리
	@PostMapping("/cookielogin")
	public String login2 (String id, String pw, boolean checkid, HttpServletResponse resp) {
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(checkid);
		
		// 정상로그인 
		//아이디 기억 여부에 따른 코드 작성 
		
		
		// 쿠기는 서버측에서 클라이언트에게 저장하는 작은 값을 말한다
		if(checkid) {
			
			Cookie cookie = new Cookie("id", id); // 쿠키 생성 
			//cookie.setMaxAge(60); // 60초 유효기간 설정 
			resp.addCookie(cookie);
			
		} else {
			//쿠키 삭제 (remove가 없음) 
			Cookie cookie = new Cookie("id", id); // 1. 같은 이름의 쿠키 생성
			cookie.setMaxAge(0); // 쿠키 삭제하려면 setMaxAge(0)으로 설정 
			resp.addCookie(cookie);
		}
		
		return "redirect:/cookiehome";
	}
	
	// 로그아웃
}
