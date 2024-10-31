package com.acorn.day3.prac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

// @Component와 동일함

@Service
public class DanServiceEx {
	//
	public ArrayList<String> dan(int dan){
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 1; i <=9; i++ ) {
			list.add(dan + " *" + i + " = " + dan * i );
		}
		return list;
	}
}
