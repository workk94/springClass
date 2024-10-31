package com.acorn.day1prac;

import lombok.Data;

@Data
public class Book {
	private String title;
	private String author;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
}
