package com.acorn.day5;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/test2.xml" })
public class MybatisControllerTest {

	@Autowired
	MemberRepository dao;
	
	@Test
	public void test() throws Exception{
		//fail("Not yet implemented");
		assertTrue(dao.selectAll().size() >=1);
		
	}

}