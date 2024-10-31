package com.acorn.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		 Calculator c = new Calculator();
		 assertTrue(c.add(3, 2)==5);
	}

}
