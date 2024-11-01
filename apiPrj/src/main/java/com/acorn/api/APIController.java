package com.acorn.api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class APIController {	

	
	/* mvc 방식에서 데이터 응답하기  , 기억해보기 */
	 
	@GetMapping("/data")
	public void method00(HttpServletResponse resp) {	
		resp.setContentType("text/html;charset=utf-8");
	 
		try {
			resp.getWriter().print("서버가 데이터 응답합니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	 
	
	//생각해보기
	//@ResponseBody가 붙여있는 경우와 없는 경우에 대해서
    // 만약   ajax로 이 요청을 했다면 서버는   test  view 내용 전체를 데이터로 반환함 
	@GetMapping("/think")
	public String test() {			 
		return "test";		
		
	}	

	
	@ResponseBody
	@GetMapping("/api1")
	public String method1() {	
		return "spring data";
	}	
	

	@ResponseBody
	@GetMapping("/api2")
	public User method2() {		
		User user = new User("acorn" ,"에이콘");
		return user;		
		
	}	
	 
	
	@ResponseBody
	@GetMapping("/api3")
	public ArrayList<User> method3() {			
		ArrayList<User> list = new ArrayList<>();
		
		  list.add( new User("acorn1" ,"에이콘"));
		  list.add( new User("acorn2" ,"에이콘"));
		  list.add( new User("acorn3" ,"에이콘"));		  
		return list;		
		
	}	
	
	
	
	
	
	
	
}
