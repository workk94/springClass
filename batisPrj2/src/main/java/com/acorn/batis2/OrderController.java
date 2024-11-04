package com.acorn.batis2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

	
	@Autowired
	OrderService service;
	
	
	
	@GetMapping("/orderList")	
	public String  getOrderList(  Model model) throws Exception {		
		model.addAttribute("list", service.getOrderList());
		return "orderView2";
	}
	

	@GetMapping("/orderList2")	
	public String  getOrderList2(  Model model) throws Exception {		
		model.addAttribute("list", service.getOrderList2());
		return "orderView2";
	}
	
}
