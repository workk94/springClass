package com.acorn.day5.batis2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
	
	@Autowired
	OrderRepository repo;
	
	
	// 전체 주문조회하기
	
	@GetMapping("/orderlist1")
	public String orderSelect() throws Exception {
		List<OrderDTO> list = repo.selectAll(); 
		System.out.println(list); // name = null => 속성명과 컬럼명이 다르면 바인딩 되지 않음 
		return "orderselect";
	}
	
	@GetMapping("/orderlist2")
	public String orderSelect2() throws Exception {
		List<OrderDTO> list  =  repo.selectAll2();
		System.out.println(list);
		return "orderselect";
	}
}
