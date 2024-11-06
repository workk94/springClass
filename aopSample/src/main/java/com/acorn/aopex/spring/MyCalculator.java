package com.acorn.aopex.spring;

import org.springframework.stereotype.Component;


@Component
public class MyCalculator {
	
	public int add( int x, int y) {
		return x+y ;
	}
	
	public int sub( int x, int  y) {
		return x-y;
	}
	
	public int test(  ) {
		return 3;
	}

}
