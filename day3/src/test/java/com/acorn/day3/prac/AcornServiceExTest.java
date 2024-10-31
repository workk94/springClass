package com.acorn.day3.prac;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"})
public class AcornServiceExTest {

	
	@Autowired
	AcornServiceEx service;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		
		List<Acorn> list = service.getAcornList();
		assertTrue(list.size() >= 1);
	}

}
