package com.acorn.day3.prac;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DBTEST3 {
	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		DataSource ds = ac.getBean(DataSource.class); //
		
		if(ds != null) System.out.println("ok");
		System.out.println(ds);
	}
}
