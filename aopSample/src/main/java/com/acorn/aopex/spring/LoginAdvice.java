package com.acorn.aopex.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice {
	@Around("execution(* com.acorn.aopex.spring.*.*( .. ))") // pointcut
	// @Around("execution(* com.acorn.aopex.spring.MyCalculator2.*( int, int))")
	//@Around("execution(* com.acorn.aopex.spring.MyCalculator2.*( int, int))")
	// @Around("execution(* com.acorn.aopex.spring.MyCalculator2.test( .. ))")
	public Object method(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("before ");

		Object result = pjp.proceed();
		// 실제 메서드를 호출합니다.
		// proceed() 메서드는 호출된 메서드의 반환 값을 제공

		// System.out.println( result);

		System.out.println(" after");

		return result;
	}

}
