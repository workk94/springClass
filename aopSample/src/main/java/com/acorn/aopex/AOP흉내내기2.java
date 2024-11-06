package com.acorn.aopex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class MyClass3{
	  public void aaa() {		  
		  System.out.println( "aaa");		 
	  }
	  
	  public void aab() {
		//  System.out.println(" before  hi"); 
		  System.out.println( "aab");
		//  System.out.println(" after bye");
	  }
	  
	  public void bbb() {
		  System.out.println( "bbb");
	  }	  
}


class MyAdvice3{

	
	//매서드의 이름이 패턴에 정해진 것과 같은지 판별하는 매서드
	public boolean matches( Method m) {		 
		 Pattern p = Pattern.compile("a.*");		
		 Matcher matcher  = p.matcher(m.getName());
		 return matcher.matches();
	}	
	 
	 
	 public Object invoke( Method m  ,  Object obj ,  Object...args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		 //매서드의 이름이 패턴과 일치하면 부가코드 수행
		 if(matches(m))
		   System.out.println("before hi");
		 
		 Object result  = m.invoke(obj, args);
		 
		//매서드의 이름이 패턴과 일치하면 부가코드 수행
		 if( matches(m))
			 System.out.println("after bye");
		 
		 return result;		 
	 }
	
	
}


public class AOP흉내내기2 {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 
	  
		  // 매서드를 직접 호출하는것이 아니라 
		  // advice 객체에게 위임한다
		  // 위임객체에서는  매서드를 호출하기 전 후에 부가기능의 코드를 추가 할 수 있다.
		  
		  
		  Class clazz  = MyClass3.class;
		  Method[] methods = clazz.getDeclaredMethods();
		  MyClass3 obj =(MyClass3) clazz.newInstance();		  
		  
		  MyAdvice3 advice = new MyAdvice3();
		  for( Method m : methods) {
			  advice.invoke(m, obj); 
		  }
		  
		  
		   

	}

}
