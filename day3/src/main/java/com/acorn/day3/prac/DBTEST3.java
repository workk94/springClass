package com.acorn.day3.prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DBTEST3 {

	public static void main(String[] args) throws SQLException {
		
		//스프링 컨테이너 객체. 독자적으로 돌아간다.
		//별도의 객체를 만들어 
	 ApplicationContext  ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
	 //ApplicationContext  ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/test.xml");
		
	 DataSource ds = ac.getBean(DataSource.class);
		
	 if(ds != null) System.out.println("ok");
	 System.out.println(ds);
		
	 
	 String sql ="select * from member_tbl_11";
	 Connection con = ds.getConnection();
	 
	 PreparedStatement pst = con.prepareStatement(sql);
	 ResultSet rs =  pst.executeQuery();
	 
	 while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	}
}
