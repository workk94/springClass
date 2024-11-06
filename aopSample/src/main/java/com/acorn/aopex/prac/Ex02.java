package com.acorn.aopex.prac;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// AOP ( 관점지향 프로그래밍) :  Aspect oriented  programming 



//핵심기능
//부가기능 
//부가기능의 코드를 관점이 다른 코드라고 한다. !!


//미션  A 클래스의 모든 매서드의 부가적인 코드를 작성해야 한다 .
// 매서드의 시작과 끝  hi!    bye ! 출력되도록하기 
// 
//2. 부가기능코드를 분리하기 

class  B{	
	 public void aa() {
		 
		  
		 System.out.println( "aa");
		 
		 
	 }
	
	 public void bb() {
		 
		 System.out.println( "bb");
		 
		 
	 }
	 public void cc() {
		 
		 System.out.println( "cc");
		  
	 }
	 
	
	
}


class BAdvice{
	
	
	//대리자역할 매서드
	// score.calc( );    // 매서드.invoke( 객체, 인자정보 )
	
	public Object  aaa(  Method m , Object o , Object ...objects) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException { 
		
		//부가코드 before
		
		System.out.println("hi@@@");
		
		Object result  = m.invoke(o, objects); //메서드 호출
		
		System.out.println("bye@@@");
		
		//부가코드 after
		return result ;
		
		
	}
	
}





public class Ex02 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		 
		Class clazz  = B.class;
		Method[]  methods= clazz.getDeclaredMethods();
		B b  = (B) clazz.newInstance();
		
		
		methods[0].invoke(b);   // a.매서드( );    // 매서드( a)     
		
		/*
		B b2 = new B();		
		b2.bb();
		*/
		
		
		//
		 BAdvice badvice  = new BAdvice();		
		//badvice.aaa(methods[0], b);
		
		//
		
		
		for( Method  m: methods) {
			badvice.aaa(m, b);
		}
		
		

	}

}
