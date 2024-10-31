package com.acorn.day3;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 서블릿 Controller -> java 작성 (@Controller)
						// -> 메서드 단위 매핑 


// 구구단 서비스 만들기 
// 스프링으로 작업 
@Controller
public class DanController {
	
	@Autowired //Injection 
	DanService service; 
 
		 
	
	@RequestMapping("/gugudan")  // GET, POST, PUT, DELETE 모든 요청 방법 
	public String  test1( @RequestParam ( required = false, defaultValue = "1" ) int dan  , Model model) {					
		ArrayList<String> danList = service.getDan(dan);
		model.addAttribute("list", danList);
		System.out.println( dan);
		return "danView";   
	}

}
