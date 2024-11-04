package com.acorn.prac5;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepoImpl implements MemberRepository{
	
	@Autowired
	private SqlSession session;
	
	// Mapper에 설정한 namespace 이름 
	private String namespace = "a.";
	
	
	// 전체조회
	@Override
	public List<MemberDTO> selectAll() {
		return session.selectList(namespace + "selectAll");
	}

	// 한명 조회(이름)
	@Override
	public MemberDTO selectOne(String id) {
		return session.selectOne(namespace + "selectOne", id);
	}

	// 멤버 삽입 
	@Override
	public int insert(MemberDTO member) {
		int rcnt = session.insert(namespace + "insert", member);
		return rcnt;
	}

	@Override
	public int update(MemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
