package com.acorn.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//매서드 단위의 매핑 
@Controller
public class RequestParam실습 {

	

	//@RequestParam 
	//스프링의 편리한 데이터 수집기능이다.
	//생략된 형태로 사용할 수 있다.
	
	
	@RequestMapping("/reg")    // required =true
	public void method1(@RequestParam String id) {    // 사용자로부터 id값을 받아옴 		
		System.out.println( id);
	 
	}
	//public String param5( @RequestParam(required = false , defaultValue = "1")  int su) {

	@RequestMapping("/reg2")              // required =false
	public void method2(  String id) {    // 사용자로부터 id값을 받아옴 		
		System.out.println( id);
	 
	}
	
	
	@RequestMapping("/reg3")  
	//public void method3(  int  su) {
	//public void method3(@RequestParam( requeired="false"  defaultValue="1")  int  su) {
	public void method3( Integer  su) {   // 쿼리스트링으로 키가 전달되지 않는경우 null반환됨  ,  null  -> int형변수 저장하려고 함  => 오류발생     		
		System.out.println( su);      // 1.해결책 ( default 값을 지정하는 방법)
		                              // 2.해결책  ( int   -> Integer로 변경한다  )
	 
	}
	
	
}
