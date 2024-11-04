package com.acorn.prac5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value ="/member", method = RequestMethod.GET)
	public String selectAll(Model model) {
		List<MemberDTO> list = service.getAllMember();
		model.addAttribute("list", list);
		
		return "member";
	}
	
	@RequestMapping(value = "/memberOne", method = RequestMethod.GET)
	public String selectOne() {
		MemberDTO m = service.getMemberByName("성기훈");
		System.out.println(m);
		return "one";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.GET)
	public String insert() {
		MemberDTO member = new MemberDTO();
		member.setId("test2");
		member.setPw("test2");
		member.setName("test2");
		member.setTel("test2");
		
		service.addMember(member);
		
		return "add";
	}
}
