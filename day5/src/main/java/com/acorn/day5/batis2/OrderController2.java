package com.acorn.day5.batis2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*   Join 쿼리시 바인딩할 객체를 별도로 만들 수 있지만   Map을 사용할 수 있다 . 편리함 */

@Controller
public class OrderController2 {

	
	@Autowired
	OrderRepository2  repository; 
	 
	
	@GetMapping("/selectOrderOne")
	public String orderselect3() throws Exception {		
		Map<String, String> list  =repository.selectOrderOne("o001");  		
		System.out.println( list);		
		return "orderselect3";
	}

	@GetMapping("/selectOrderList")
	public String orderselect4() throws Exception {		
		List< Map< String,String>> list  =repository.selectOrderList();  		
		System.out.println( list);		
		return "orderselect3";
	}

}
