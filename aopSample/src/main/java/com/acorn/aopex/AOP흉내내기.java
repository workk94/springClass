package com.acorn.aopex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;
 

class MyClass{
	  public void aaa() {		  
		  System.out.println( "aaa");		 
	  }
	  
	  public void aab() {
		//  System.out.println("hi");
		  System.out.println( "aab");
		//  System.out.println("bye");
	  }
	  
	  public void bbb(  ) {
		  System.out.println( "bbb");
	  }	  
}



//위임객체
class MyAdvice{	
	
	
	//매서드정보, 객체 , 매개변수
	 public Object invoke( Method m  ,  Object obj ,  Object...args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException   {
	  
		 System.out.println("before hi");	
		 
		 Object result  = m.invoke(obj, args);
		 
		 System.out.println("after bye");	
		 
		 return result;
		 
	 }
	
	
}


public class AOP흉내내기 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 
		  MyClass  my = new MyClass();
		  my.aaa();
		  my.aab();
		  my.bbb(); 
		  
		  
		  //############################
		    
		  Class clazz  = MyClass.class;
		  Method[] methods = clazz.getDeclaredMethods();
		  MyClass obj =(MyClass) clazz.newInstance();		  
		  
		  
		  //advice 객체 생성
		  MyAdvice advice = new MyAdvice();
		  for (Method m : methods) { 
	          advice.invoke(m, obj );  	             
	      }

	}

}
