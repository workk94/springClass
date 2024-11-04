package com.acorn.day5.batis2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	String orderNo;
	String userid;
	String name; // username(테이블 컬럼명)
	String tel;
	String price;
}
