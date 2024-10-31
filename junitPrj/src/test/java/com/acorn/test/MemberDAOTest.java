package com.acorn.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class) 
 @ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"} )

public class MemberDAOTest {

	@Autowired
	MemberDAO dao;
	
 
	
	 @Test
	public void testSelect() {

		assertTrue( dao.select() !=null);

	}
	 
	
 
	public void testInsert() {

		assertTrue( dao.insert(new Member("p1","0000","한길동","000-1111-2222")) ==1);

	}

}
