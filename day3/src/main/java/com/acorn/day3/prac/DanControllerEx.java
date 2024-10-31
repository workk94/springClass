package com.acorn.day3.prac;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DanControllerEx {
	
	@Autowired
	DanServiceEx service; // 필드 Injection
	
	// 매서드 단위 매핑
	@RequestMapping(value="/danex")
	public String gugudan(@RequestParam(required=false, defaultValue="3") int dan, Model model) {
		
		// 3단 정보 만들기, 서비스 만들고 제공하기
		
		ArrayList<String> danData = service.dan(dan);
		model.addAttribute("data", danData);
		
		return "gugudan";
	}
}
