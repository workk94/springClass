package com.acorn.day3;

import java.util.ArrayList;

import org.springframework.stereotype.Component;


@Component // @Service @Repository => 객체를 생성 @Componant과 동일 , 의미만 부여된 애너테이션 
			// 
public class DanService {
	
	
	public ArrayList<String> getDan( int dan){		
		ArrayList<String> danList = new ArrayList<>();		 
		for( int i=1 ; i<=9; i++) {
			danList.add(dan+"*" +i +"="+dan*i);  // " 3*1= 3 "
		}		 		 
		return danList;
		
	}

}
