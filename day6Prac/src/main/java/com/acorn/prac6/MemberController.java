package com.acorn.prac6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	MemberRepo repo;
	
	@RequestMapping(value = "/selectMember", method = RequestMethod.GET)
	public String selectAll() throws Exception {
		List<Member> list =  repo.selectAll();
		System.out.println(list);
		
//		for(Member m : list) {
//			System.out.println(m.getName());
//		}
		
		list.forEach(member -> member.getName());
		
		return "selectAll";
	}
}
