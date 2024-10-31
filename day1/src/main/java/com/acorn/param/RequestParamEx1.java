package com.acorn.param;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamEx1 {
	
	
	// 사용자화면에서  과일정보가 여러개 오는 경우 
	// 스프링과 이전의 MVC2 코드를 비교해 보자
	
	@RequestMapping(value="/paramT1" ,  method=RequestMethod.POST ) 
	public String  test1(@RequestParam String[] fruit) {		
		System.out.println( Arrays.toString(fruit));		
		return "view";
	}
	
	
	@RequestMapping(value="/paramT2" ,  method=RequestMethod.POST ) 
	public String  test2(@RequestParam ArrayList<String> fruit) {		
		System.out.println("fruit" +  fruit);		
		return "view";
	} 
	
	
	// MVC2에서 사용한 코드 
	@RequestMapping(value="/paramT3" ,  method=RequestMethod.POST ) 
	public String  test3( HttpServletRequest request) {		
	 
		// fruit이라는 이름으로 여러개 오는 경우  getParameterValues 사용
		String[] fruit = request.getParameterValues("fruit");
		System.out.println( Arrays.toString(fruit));
		return "view";
	} 
	

}
