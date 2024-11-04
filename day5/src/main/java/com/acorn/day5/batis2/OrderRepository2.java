package com.acorn.day5.batis2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository2 {

	
	@Autowired
	SqlSession session;
	
	String namespace ="c.";
	 
	//결과가 한 개인 객체로 가져오기 
	//별도의 DTO클래스 만들지 않고  Map을 사용할 수 있음
	//키는 컬럼명으로 지정됨 
	
	public Map<String, String>  selectOrderOne(String id) throws Exception{
		Map<String, String>list  =session.selectOne(namespace+"orderOne" , id);
		return list;
	} 
	
	
	//별도의 DTO 객체를 만들지 않고 Map을 사용하여 리스트로 가져올 수 있음 
	//키는 컬럼명으로 지정됨 
	
	public List<  Map<String,String>>  selectOrderList() throws Exception{
		List<  Map<String,String>>list  =session.selectList(namespace+"orderselectMap"  );
		return list;
	}
}
