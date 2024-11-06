package com.acorn.aopex.prac;



// AOP ( 관점지향 프로그래밍) :  Aspect oriented  programming 



//핵심기능
//부가기능 
//부가기능의 코드를 관점이 다른 코드라고 한다. !!


//미션  A 클래스의 모든 매서드의 부가적인 코드를 작성해야 한다 .
// 매서드의 시작과 끝  hi!    bye ! 출력되도록하기 
//1. 모든매서드의 부가기능 코드를 작성한다

class  A{	
	 public void aa() {
		 
		 System.out.println("hi!!");
		 System.out.println( "aa");
		 System.out.println("bye!!");
		 
	 }
	
	 public void bb() {
		 System.out.println("hi!!");
		 System.out.println( "bb");
		 System.out.println("bye!!");
		 
	 }
	 public void cc() {
		 System.out.println("hi!!");
		 System.out.println( "cc");
		 System.out.println("bye!!");
	 }
	 
	
	
}





public class Ex01 {

	public static void main(String[] args) {
		 
		
		A a  = new A();
		a.aa();
		a.bb();
		a.cc();

	}

}
