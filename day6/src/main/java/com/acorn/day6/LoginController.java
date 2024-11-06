package com.acorn.day6;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	
	// 로그인 화면
	
	@GetMapping("/mylogin")
	public String login1 () {
		return "mylogin";
	}
	
	// 로그인 처리 
	
	@PostMapping("/mylogin")
	public String login2 (String id, String pw, HttpServletRequest req) {
		
		
		if(!checkId(id, pw)) { // 올바르지 않은 경우 다시 로그인 요청 
			return "redirect:/mylogin";
		}
		// 성공하면 홈 화면으로 리다이렉트 요청 
		// 세션에 저장하기
		//세션은 서버측 저장소이다 (하나의 사용자가 공유할 수 있는 저장소)	
		
		HttpSession session = req.getSession();
		session.setAttribute("userId", id);
		
		return "redirect:/myhome"; // response.sendRedirect("/day6/myhome");
	}
	
	
	
	// 아이디 검증 
	boolean checkId(String id, String pw) {
		return "acorn".equals(id) && "1234".equals(pw);
	}
	
	
	// 로그아웃 
	
	@GetMapping("/mylogout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("userId");
		return "redirect:/myhome";
	}
	
}
