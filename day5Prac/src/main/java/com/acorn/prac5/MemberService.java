package com.acorn.prac5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository repo;
	
	public List<MemberDTO> getAllMember(){
		return repo.selectAll();
	}
	
	public MemberDTO getMemberByName(String name) {
		return repo.selectOne(name);
	}
	
	public int addMember(MemberDTO member) {
		return repo.insert(member);
	}
	
}
