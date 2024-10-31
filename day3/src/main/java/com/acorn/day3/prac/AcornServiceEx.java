package com.acorn.day3.prac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service 
public class AcornServiceEx {

	@Autowired
	AcornDAOEx4 repository;

	// 에이콘 학생목록 제공하기 서비스
	public List<Acorn> getAcornList() {

		List<Acorn> list = repository.selectAll();
		return list;
	}

}
