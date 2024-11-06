package com.acorn.prac6;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
	
	@Autowired
	OrderRepo repo;
	
	@RequestMapping(value = "/selectOrder", method = RequestMethod.GET)
	public String selectOrder () throws Exception{
		
		List<Map<String,String>> list = repo.selectOrder();
		
		list.forEach(item -> System.out.println(item));
		
		return "selectOrder";
	}
	
	@GetMapping("/selectOrderone")
	public String  selectOrderone() throws Exception {		
		Map<String, String>  order  = repo.selectOrderOne();		
		System.out.println( order);
		return "selectOrdeone";
	}
}
