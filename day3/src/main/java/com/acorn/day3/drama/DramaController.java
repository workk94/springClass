package com.acorn.day3.drama;

 

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DramaController {

	@Autowired
	DramaService service;
 

	
	@RequestMapping("/dramas")
	public String drama3(Model model) {
		 
	    ArrayList<Drama> list = service.getDramasInfo();
		model.addAttribute("dList",list);		 
		return "drama";
	}
	
}
