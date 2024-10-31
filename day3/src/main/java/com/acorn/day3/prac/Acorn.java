package com.acorn.day3.prac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 매개변수가 전부 있는 생성자 
public class Acorn {
	
	String id;
	String pw;
	String name;
	

}
