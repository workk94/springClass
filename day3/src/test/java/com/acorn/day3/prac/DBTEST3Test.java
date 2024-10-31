package com.acorn.day3.prac;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"})
public class DBTEST3Test {

	@Autowired
	DataSource ds;
	
	@Test
	public void test() {
		
		//fail("Not yet implemented");
		
		assertNotNull(ds);
		
		//assertTrue(ds != null);
		
	}

}
