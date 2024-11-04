package com.acorn.prac5;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/**/test2.xml" })
public class MemberRepoImplTest {

	@Autowired
	MemberRepository repo;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		List<MemberDTO> list =  repo.selectAll();
		assertTrue( list != null);
		list.forEach(t -> System.out.println(t));
	}

}
