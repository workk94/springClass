package com.acorn.day5.batis2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
	
	
	
	@Autowired
	private SqlSession session;
	private String namespace = "b.";
	
	
	// 전체 주문 조회
	public List<OrderDTO> selectAll() throws Exception {
		List<OrderDTO> list = session.selectList(namespace + "orderselect1"); // b.orderselect
		return list;
	}
	
	//전체 주문 조회2
	public List<OrderDTO> selectAll2() throws Exception {
		return session.selectList(namespace + "orderselect2");
	}
	
}
