package com.acorn.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

 

public class DataSourceTestTest2 { 
	
	@Test
	public void test() throws SQLException { 
		
			ApplicationContext ac = new GenericXmlApplicationContext( "file:src/main/webapp/WEB-INF/spring/test.xml"  );
		    DataSource  ds=  ac.getBean(DataSource.class);
			Connection con= ds.getConnection();			
			assertTrue( con != null);
	}

}
