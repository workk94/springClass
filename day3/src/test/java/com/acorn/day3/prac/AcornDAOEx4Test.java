package com.acorn.day3.prac;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"})
public class AcornDAOEx4Test {

	@Autowired
	AcornDAOEx4 dao;
	
	//@Test
	public void test() {
		//fail("Not yet implemented");
		
		
		Acorn acorn = dao.selectOne("kmg");

		assertTrue(acorn != null);
		//assertEquals("김무궁", acorn.getName());
	}
	
	//@Test
	public void test2() {
		
		int row = dao.insert(new Acorn ("acorn50", "1234", "홍길동"));
		
		assertTrue(row != 0);
	}
	
	@Test
	public void test3() {
		//Hashmap, "키" 값의 쌍으로 데이터를 저장함
		Map<String, String> info = new HashMap<>();
		info.put("id", "kimcw");
		info.put("pw", "9999");
		int row = dao.update(info);
		
		
		assertTrue(row != 0);
	}
	
	//@Test
	public void test4() {
		int cnt = dao.delete("acorn50");
		
		assertTrue(cnt != 0);
	}

}
