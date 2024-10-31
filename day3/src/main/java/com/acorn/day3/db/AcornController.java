package com.acorn.day3.db;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AcornController {
	
	
	@Autowired
	AcornDAO dao;
	
	
	@RequestMapping("/list")
	public void acornlist() {
		ArrayList<Customer> list =dao.selectAll();
		System.out.println( list);
	}	
	
	
	@RequestMapping("/acorn")
	public String acornForm() {
	 return "acornForm";
	}
	
	
	@RequestMapping( value="/acorn", method = RequestMethod.POST )
	public String registerAcorn(Customer customer) {		
		dao.insertMember(customer); 		
	 return "redirect:/";
	}
	
	

}
