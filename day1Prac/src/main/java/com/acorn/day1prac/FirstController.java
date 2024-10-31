package com.acorn.day1prac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


//view가 응답 
@Controller
public class FirstController {
	
	// 매서드 단위의 매핑을 지원 
	
	@GetMapping("/hi1")
	public void hi1() {
		// Model
		// View : 요청정보 hi1이라는 view 
	}
	
	
	// 
	@GetMapping("/hi2")
	public String hi2() {
		return "login"; // login 뷰를 찾음 
	}
	
	@PostMapping("hi2")	//@RequestParam 생략가능 ( 스프링이 데이터 수집 )
	public String hi3(String id, String pw) {
		
		//데이터베이스에서 확인 id, pw 
		System.out.println(id);
		System.out.println(pw);
		
		return "home";
	}
	
	
	@PostMapping("/hi3")
	public String hi4(Member member) { //@ModelAttribute 생략됨
										// 모델에 저장해줌, 키이름: Type의 첫글자 소문자 규칙 
										// 반드시 기본생성자가 존재해야한다 
										// setter 존재해야한다 
			
		System.out.println("id= " + member.getId());
		System.out.println("pw= " + member.getPw());
		// 데이터 베이스에서 확인 id, pw
		
		return "home";
	}
	
}
