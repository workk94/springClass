package com.acorn.day5;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component, 두개 역할은 동일함 
//@Repository 

@Repository
public class MemberRepository {
	
	@Autowired
	SqlSession session;
	
	// .을 붙이는 이유는 .밑의 id 값을 찾기 위해서임 
	String namespace = "a.";
	
	
	//전체조회
	public List<Member> selectAll() throws Exception{
		//session.selectList("a." + "selectAll");
		return session.selectList(namespace + "selectAll");
	}
	
	//삽입
	public int insert( Member member) throws Exception{
		//return session.insert(namespace + "insert", member);
		int rcnt = session.insert(namespace + "insert", member);
		return rcnt;
	}
	
	//삭제 
	public int deleteOne(String id) throws Exception {
		// a.delete 
		int rcnt = session.delete(namespace + "delete", id);
		return rcnt;
	}
	
	//변경
	
	public int update(Member m) throws Exception {
		int rcnt = session.update(namespace+ "update", m);
		return rcnt;
	}
	
	
	//한명 조회
	public Member selectOne(String id) throws Exception {
		return session.selectOne(namespace +"selectOne", id);
	}
}
