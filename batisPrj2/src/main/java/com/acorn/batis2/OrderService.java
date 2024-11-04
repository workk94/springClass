package com.acorn.batis2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	
	
	@Autowired
	OrderRepository  repository;
	
	
	
	public List<OrderDTO>  getOrderList() throws Exception{
		return repository.selectAll();
		
	}
	
	public List<OrderDTO>  getOrderList2() throws Exception{
		return repository.selectAll2();
		
	}
	
}
