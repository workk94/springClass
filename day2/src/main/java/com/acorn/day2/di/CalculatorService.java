package com.acorn.day2.di;

public class CalculatorService {

	
	//
	Calculator cal ; // 멤버 변수는 자료형의 기본값으로 초기화해줌, 참조형 변수의 기본값 : null
	
	//주입(Injection)
	//생성자, Setter
	
	public CalculatorService() {
		// TODO Auto-generated constructor stub
	}
	
	public CalculatorService(Calculator cal) {
		super();
		this.cal = cal;
	}


	public void setCal(Calculator cal) {
		this.cal = cal;
	}

	public void addNumber (int su1, int su2) {
		
		// 
		int result = cal.add(su1, su2);
		System.out.println("결과는 " + result);

	}
	
	//test
	public static void main(String[] args) {
		//CalculatorService service = new CalculatorService();
		//service.addNumber(10, 5); // 오류 발생 NullPointerException Calculator 객체가 없기 때문에 
								// 외부에서 받도록 하자 (Injection)
		//NullPointerException => 코드 수정
		
		
		// 수정 
		//계산기 객체 Setter Injection
		CalculatorService s = new CalculatorService();
		
		//s.setCal(new AcornCalculator());
		AcornCalculator calculator = new AcornCalculator();
		s.setCal(calculator);
		s.addNumber(10, 5);
		
		// String str = null;
		// char i = str.charAt(0);
		
		//계산기 객체 constructorInjection 
		
		AcornCalculator calculator2 = new AcornCalculator();
		CalculatorService s2 = new CalculatorService(calculator2);
		s2.addNumber(3, 2);
		
	}
}
