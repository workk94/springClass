package com.acorn.batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
 
 
 
@Controller
public class MybatisController {
	
	@Autowired
	MemberService service;
	 
	
	@RequestMapping("/count")
	public void test( ) {		
		 	try {
		 		System.out.println(		service.getTotalMemberCount());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 
	
	@RequestMapping("/selectAll")
	public void test2( ) {		
		 	try {
		 		System.out.println(		service.getAllMembers());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 
	
	@RequestMapping("/insert")
	public void test3( ) {		
		 	try {
		 		Member m = new Member();		 		
		 		m.setId("test01");
		 		m.setPwd("4545");
		 		m.setName("홍길동");
		 		service.registerNewMember(m) ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	@RequestMapping("/delete")
	public void test4( ) {		
		 	try {
		 		System.out.println(	 service.deleteMemberById("test01"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	@RequestMapping("/deleteAll")
	public void test5( ) {		
		 	try {
		 		System.out.println(		service.deleteAllMembers());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	@RequestMapping("/update")
	public void test6( ) {		
		 	try {
		 		Member m  = new Member();
		 		m.setId("test01");
		 		m.setPwd("9999");
		 		m.setName("홍길동");
		 		
		 		System.out.println(		service.modifyMemberInfo(m));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 

}
