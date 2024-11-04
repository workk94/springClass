package com.acorn.day5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MybatisController {

	@Autowired
	private MemberRepository repository;

	@GetMapping("/selectAll")
	public String selectAll() throws Exception {
		List<Member> list = repository.selectAll();
		System.out.println(list);
		return "selectAll";
	}

	@GetMapping("/insert")
	public String insert() throws Exception {
		Member m = new Member("acorn3", "1234", "홍길순");
		repository.insert(m);
		return "insert";
	}

	@GetMapping("/delete")
	public String delete() throws Exception {

		repository.deleteOne("a01");
		return "delete";
	}
	
	@GetMapping("/update")
	public String update() throws Exception  {
		Member member = new Member("a02", "7777", "김길순");
		repository.update(member);
		return "update";
	}
	
	@GetMapping("/selectOne")
	public String selectOne() throws Exception{
		Member member = repository.selectOne("a03");
		System.out.println(member);
		return "selectOne";
	}
	
}
