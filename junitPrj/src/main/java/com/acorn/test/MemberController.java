package com.acorn.test;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	
	@Autowired
	MemberService service;
	
	
	@RequestMapping( value="/members" , method=RequestMethod.GET)
	public String getMembers(Model model) {
		 ArrayList<Member> list =service.list();
		 model.addAttribute("list", list);
		 return "memberList";
	}
	
}
