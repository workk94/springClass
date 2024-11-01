package com.acorn.day4;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

 

@Controller
public class UserAPIController {  
	
	//사용자정보 조회하기 
	//사용자정보 json형태로 응답하기
	@ResponseBody
	@RequestMapping( value="/users" , method = RequestMethod.GET)
	public ArrayList<User>  getUsers(){		
		ArrayList<User> list = new ArrayList<>();
		list.add( new User("acorn1" ,"kim"));
		list.add( new User("acorn2" ,"lee"));
		list.add( new User("acorn3" ,"jun"));		
		return list;
	}
	 
	
	//사용자 등록하기
	@ResponseBody
	@RequestMapping( value="/users",  method = RequestMethod.POST)
	public int registerUser(@RequestBody  User user) {		
		System.out.println( "등록"+ user);
		System.out.println( "등록합니다");
		return 1;		
	}
	
	//사용자 변경하기 
	
	@ResponseBody      
	@RequestMapping( value="/users"  , method=RequestMethod.PUT)
	public int modifyUser( @RequestBody User user) {		
		System.out.println( "수정"+  user);
		System.out.println( " 수정합니다");
		return 1;
	} 
	
	
	//사용자 삭제하기
	@ResponseBody
	@RequestMapping( value="/users/{id}" , method = RequestMethod.DELETE)
	public int  deleteUser(  @PathVariable String id) {   // @PathVariable  추가		
		System.out.println( "삭제합니다");
		System.out.println( id);
		return 1;
	}
	 
	
	
}
