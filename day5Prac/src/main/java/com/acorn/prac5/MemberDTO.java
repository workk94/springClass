package com.acorn.prac5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String birthday;
	private String point;
	private String grade;
}
