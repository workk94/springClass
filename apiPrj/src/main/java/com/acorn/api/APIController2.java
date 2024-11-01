package com.acorn.api;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController2 {
	
	/*
	 매핑관련 라이브러리 
   		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-databind</artifactId>
		    <version>2.15.2</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl -->
		<dependency>
		    <groupId>org.codehaus.jackson</groupId>
		    <artifactId>jackson-mapper-asl</artifactId>
		    <version>1.9.13</version>
		</dependency>
	 */	
	@ResponseBody
	@GetMapping("/json")
	public String method() {		
		return "americano";
	}
	
	
	@ResponseBody
	@GetMapping("/json2")
	public User method2() {
		User user = new User("acorn","0000");
		return user;
	}	
	

	@ResponseBody
	@GetMapping("/json3")
	public ArrayList<User> method4() {		
		ArrayList<User> list = new ArrayList<>();
		list.add( new User("acorn1" ,"kim"));
		list.add( new User("acorn2" ,"lee"));
		list.add( new User("acorn3" ,"jun"));		
		return list;
	}
 
	 
	
	//#### 고객조회하기 #####
	
	@ResponseBody
	//@GetMapping("/memberlist")
	@GetMapping("/member")
	public ArrayList<User> method5() {	
		System.out.println( "고객목록 데이터");
		ArrayList<User> list = new ArrayList<>();
		list.add( new User("acorn1" ,"kim"));
		list.add( new User("acorn2" ,"lee"));
		list.add( new User("acorn3" ,"jun"));		
		return list;
	}
	
	
	//#### 고객등록 하기 #####
	
	@ResponseBody                        // 
	//@PostMapping("/memberRegister")	// @RequestBody   =>  json =>자바객체로 바인딩해줌 
	@PostMapping("/member")     
	public int method4( @RequestBody User user )   {	
		System.out.println( user);	
		System.out.println( "등록합니다");		
		return 1;
	}	 
	
	
	/*
	 * 기존 MVC2 코드와 비교해 보자 	 * 
	 * 리뷰등록하기.txt
	 * 
	 */
	
	//#### 고객변경하기 #####
	@ResponseBody
	//@PutMapping("/memberModify/{id}")
	@PutMapping("/member/{id}")
	public String method5( @RequestBody User user ,  @PathVariable String id ) {	
		System.out.println( user);
		System.out.println( id);
		System.out.println( "고객 정보를 수정합니다");
		return "1";
	}
		
	//#### 고객삭제하기 #####
	@ResponseBody
	//@DeleteMapping("/memberDelete/{id}") 
	@DeleteMapping("/member/{id}")   //PathVariable
	public String method6(   @PathVariable String id ) {	
		System.out.println( "고객 정보를 삭제합니다"); 
		System.out.println( id);
		return "1";
	}
	
 
}
