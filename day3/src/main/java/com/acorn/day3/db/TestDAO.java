package com.acorn.day3.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 
 * 		<dependency>
		    <groupId>com.oracle.ojdbc</groupId>
		    <artifactId>ojdbc8</artifactId>
		    <version>19.3.0.0</version>
		</dependency>

		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jdbc</artifactId>
		    <version>${org.springframework-version}</version>
		</dependency>
	
 * 
 * 
 */


/* 
 * 	<bean    class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
		<property name="url" value="jdbc:oracle:thin:@localhost:1521:testdb"></property>
		<property name="username" value="scott"></property>
		<property name="password" value="tiger"></property>
	</bean>
		
 */

 


@Component
public class TestDAO {	
	
	@Autowired
	DataSource ds;	   //생성된 DriverManagerDataSource  객체를 주입받는다 
	
	
	public ArrayList<Customer> select() {	
		
		String sql="select * from member_tbl_11";
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			Connection con = ds.getConnection();
			PreparedStatement  pst =con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));	
				
				Customer c  = new Customer( rs.getString(1) , rs.getString(2) , rs.getString(3));
				list.add(c);
			} 			
			//
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return list;
		
	}
}
