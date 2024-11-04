package com.acorn.day5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//MemberDTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	// 테이블의 컬럼명과 일치하게 작성 (기준으로 적용됨)
	String id;
	String pwd;
	String name;
}
