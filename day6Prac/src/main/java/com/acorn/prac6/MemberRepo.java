package com.acorn.prac6;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepo {
	
	@Autowired
	private SqlSession session;

	private String namespace = "b.";
	
	// 회원 목록 조회하기
	
	public List<Member> selectAll() throws Exception{
		return session.selectList(namespace + "selectMember");
	}

}
