package com.acorn.prac6;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepo {

	@Autowired
	private SqlSession session;
	String namespace = "com.acorn.OrderMapper.";

	public List<Map<String, String>> selectOrder() throws Exception {
		return session.selectList(namespace + "selectOrder");
	}

	public Map<String, String> selectOrderOne() throws Exception {

		// 주키로 검색하는 경우, 결과가 반드시 한 개여야 한다.
		String id = "J001";
		Map<String, String> order = session.selectOne(namespace + "selectOrderOne", id);
		return order;
	}
}
