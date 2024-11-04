package com.acorn.batis;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"} )
 
public class MemberServiceTest {

	
	@Autowired	
	MemberService  service;
	
	@Test
	public void test() throws Exception {
		//fail("Not yet implemented");		
		int result  =service.registerNewMember(new Member("test99","1234","장주원" ));
		assertTrue(result ==1);
	}

}
