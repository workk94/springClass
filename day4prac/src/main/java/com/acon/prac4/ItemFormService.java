package com.acon.prac4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemFormService {
	@Autowired
	ItemFormDAO dao;
	
	public int save(String id, String name) {
		return dao.insert(id, name);
	}
}
