package com.acorn.day3.prac;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"})
public class DanServiceExTest {

	
	@Autowired
	DanServiceEx service;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		
		ArrayList<String > dan = service.dan(3);
		assertTrue(dan.size() == 9);
	}

}
