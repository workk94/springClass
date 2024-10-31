package com.acorn.day1prac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

	@GetMapping("/book")
	public String bookInfo() {
		return "book";
	}

	@PostMapping("/getBook")
	public String getBookList(Model model) {
		List<Book> bookList = new ArrayList<>();

		bookList.add(new Book("자바의정석", "남궁성", 25000));
		bookList.add(new Book("스프링", "구멍가게 코딩단", 32000));
		bookList.add(new Book("자바스크립트", "제로초", 18000));
		
		model.addAttribute("bookList", bookList);
		return "book";
	}
}
