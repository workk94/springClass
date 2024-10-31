package com.acorn.day3.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBTest2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";

		
		// 스프링이 제공하는 DataSource 구현체 
		// Connection 객체관리 해줌 (커넥션 풀링 기법 )
		DriverManagerDataSource ds = new DriverManagerDataSource();		
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);

		Connection con = ds.getConnection();

		String sql = "select * from member_tbl_11";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}

		//데이터베이스 객체 close 
		if (rs != null)
			rs.close();
		if (pst != null)
			pst.close();
		if (con != null)
			con.close();

	}
}
