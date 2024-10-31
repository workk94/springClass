package com.acorn.day1prac;

import lombok.Data;

@Data
public class Review {
	String title;
	String content;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
}
