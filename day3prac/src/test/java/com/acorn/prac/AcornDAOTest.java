package com.acorn.prac;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AcornDAOTest {

	@Autowired
	AcornDAO dao;

	//@Test
	public void test() {
		// fail("Not yet implemented");
		List<Acorn> list = dao.selectAll();

		assertTrue(list != null);

		list.forEach(t -> System.out.println(t));
	}

	//@Test
	public void test2() {
		Acorn acorn = dao.selectOne("김정석");

		assertTrue(acorn != null);
	}

	
	@Test
	public void test3() {
		Map<String, String> map = new HashMap<>();
		
		map.put("id", "test2");
		map.put("pw", "test2");
		map.put("name", "test2");
		
		int result = dao.insert(map);
		
		assertTrue(result != 0);
	}
}
