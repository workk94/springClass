package com.acorn.project;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantRepository {
	@Autowired
	private SqlSession session;
	
	private String namespace = "a."; 
	
	// 가게 추가 
	public int insert(Restaurant restaurant) {
		return session.insert(namespace + "insertRestaurant" , restaurant);
	}
	
	// 가게 조회 
	public List<Restaurant> selectOneByCategory(String category){
		return session.selectList(namespace + "selectRestaurantByCategory", category);
	}
}
