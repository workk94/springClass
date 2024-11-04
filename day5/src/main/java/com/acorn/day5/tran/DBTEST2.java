package com.acorn.day5.tran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTEST2 {

	public static void main(String[] args) {
		
		
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:testdb";
		String user="scott";
		String password="tiger";		
		 
	   
		
		Connection  con=null;
		
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
			 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// 2개 작업  => 모두 수행되거나 수행되지 않아야 한다  ( 비지니스에서 하나의 논리적인 단위 : 트랜잭션 )		
		
		//트랜젝션 처리
		//수동커밋으로 변경
		//반드시 같은 커넥션이어야 한다. !! 
		
		try {
			
			// 수동커밋으로 변경 
			con.setAutoCommit(false);
			
			String sql1= " insert into testdb values( 'acorn2', '1234')";			
			PreparedStatement   pst  = con.prepareStatement(sql1);
			pst.executeUpdate();
			
			
			String sql2= " insert into testdb values( 'acorn2', '1234')";			
			PreparedStatement   pst2  = con.prepareStatement(sql2);
			pst2.executeUpdate(); 
			
			// 두개의 작업에서 문제가 없는 경우에 최종적으로 반영하는 commit;
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			//문제가 발생하면 되돌리기 rollback 하기 
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		

	}

}
