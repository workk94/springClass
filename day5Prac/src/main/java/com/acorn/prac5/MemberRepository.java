package com.acorn.prac5;

import java.util.List;

public interface MemberRepository {
	
	// 멤버전체조회
	public List<MemberDTO> selectAll();
	
	// 멤버 조회(name)
	public MemberDTO selectOne(String name);
	
	// 멤버 추가 
	public int insert(MemberDTO member);
	
	// 멤버 수정
	public int update(MemberDTO member);
	
	// 멤버 삭제 
	public int deleteOne(String id);
	
}
