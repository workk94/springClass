package com.acorn.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {
	
	Calculator cal =new Calculator();

	@Test
	public void test() {
	//	fail("Not yet implemented");
	int result=	cal.add(5, 3);
	
	assertEquals(8, result);
	}
	

}
