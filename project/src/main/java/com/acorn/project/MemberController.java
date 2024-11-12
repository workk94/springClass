package com.acorn.project;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class MemberController {
	
	@Autowired
	KakaoApiService service;
	
	
	@GetMapping("/test")
	public String getRestaurantList() throws Exception {
		
		// db에 api에서 가져온 정보를 저장
		service.fetchAndSaveRestaurants();
		return "test";
	}
	
	
	// 로그인
	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String id, String pw, boolean checked, HttpServletResponse response) {
        // 로그인 성공/실패 로직을 여기에 추가
        System.out.println("ID: " + id);
        System.out.println("Password: " + pw);
        System.out.println("Remember ID: " + checked);

        if (checked) {
            Cookie cookie = new Cookie("id", id);
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("id", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        return "redirect:/main";
    }
	
	
	// 로그아웃 
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.invalidate();

        Cookie cookie = new Cookie("id", null);
        cookie.setMaxAge(0); // 쿠키 삭제
        cookie.setPath("/");  // 쿠키 경로 설정
        response.addCookie(cookie);
        
        return "redirect:/project/login";
    }
	
	// 회원가입
	@GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }
	
	@PostMapping("/signup")
	public String signUp(){
		return "";
	}
	
}
