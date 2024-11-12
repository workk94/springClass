package com.acorn.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository repository;
	
	public int addRestaurantInfo (Restaurant restaurant) {
		return repository.insert(restaurant);
	}
	
}
