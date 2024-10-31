package com.acorn.day2.di2;

import lombok.RequiredArgsConstructor;


//@Data
//@Getter @Setter
//@ToString
//@ToString(of = {"id", "pw"})
//@NoArgsConstructor

// 매개변수가 있는 생성자 
//멤버변수 앞에 final 키워드 붙여줘야 함 
@RequiredArgsConstructor
public class Acorn {
	final String id;
	final String pw;
}
