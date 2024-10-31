package com.acorn.di.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProgramTestSpringContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		 /*
	     * 객체 생성, 주입 =>  Spring Ioc Container * 
	     * 지시서 작성 : xml , java config  , 어노테이션	       
	     */		
		ApplicationContext ac = new GenericXmlApplicationContext( "com/acorn/di/calculator/setting.xml"  );
	
		
		//스프링 컨테이너로 부터 값을 얻어오는 두 가지 방법
		// 1. bean의 클래스 type
		// 2. bean의 id로
		
		//Program  program  = ac.getBean(Program.class);		
		// 	program.addNumber(5, 3); 
		Program  program2= (Program) ac.getBean("program");
		program2.addNumber(5, 4); 
		
 

	}

}
/*

ApplicationContext 객체를 직접 생성하면,
이는 웹 프로젝트에서 Spring이 제공하는 기본적인 서블릿 기반의 스프링 컨테이너와는 다른 독립적인 컨텍스트이다 
ApplicationContext를 직접 생성하면 독립적인 스프링 컨테이너가 생성되므로, 웹 애플리케이션의 라이프사이클이나 요청/응답 흐름과는 연결되지 않는다
특정한 기능을 테스트하거나 간단한 Java 프로그램에서 스프링의 의존성 주입을 활용하려는 목적임

*/