package com.acorn.day3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 

@Component
public class AcornDAO {
 
	
	@Autowired
	DataSource ds;
	
	 
	public ArrayList<Customer> selectAll(){		 
		String sql="select * from acorntbl";	
		 
		Connection  con = null;
		PreparedStatement pst=null;
		ResultSet rs =null;
		
		ArrayList<Customer> list =new ArrayList<>();
		try {
			con  =ds.getConnection();
			pst=con.prepareStatement(sql);
			rs =pst.executeQuery();
			
			while( rs.next()) {
				String  id= rs.getString(1);
				String  pw= rs.getString(2);
				String  name= rs.getString(3);
				Customer c = new Customer( id, pw, name);
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//해제
		close(rs,pst, con);
		return list;		
	}
	
 
	
	public Customer selectOne( String id) {		 
			 
		String sql =" select * from acorntbl where id= ? ";
		
		Connection con= null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		Customer customer =null;
		try {
			con  =ds.getConnection();	
			pst=con.prepareStatement(sql);
			pst.setString(1, id);		
			 
			rs=pst.executeQuery();			
			if( rs.next() ) {
				String id_tmp = rs.getString(1);
				String pw_tmp = rs.getString(2);
				String name_tmp = rs.getString(3);
				customer = new Customer( id_tmp, pw_tmp, name_tmp);				 
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {			
			close( rs,pst, con);
		}
		return customer;
	}	
	
  
	 
	
	public void insertMember( Customer c) {
	 
		String sql="insert into acorntbl values(?,?,?)";
		Connection con= null;
		PreparedStatement pst=null;
		try {
			con  =ds.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1, c.getId());
			pst.setString(2, c.getPw());
			pst.setString(3, c.getName());
			pst.executeUpdate();
		} catch (SQLException e) {		 
			e.printStackTrace();
		}		
		
		close( pst, con);		
	}
	
	
	//삭제
	
	public int deleteOne(String id) {
		 	
	
		int rows=0;
		String sql = " delete from acorntbl where id= ?  ";
		Connection con= null;
		PreparedStatement  pst=null;
		try {
			  con  =ds.getConnection();
			  pst =con.prepareStatement(sql);
			  pst.setString(1, id); 
			  rows=pst.executeUpdate();
			  
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		close(pst, con);		
		return rows;
	}
	
	
	
	
	public void close( AutoCloseable ...a) {
		for( AutoCloseable  item : a) {
		   try {
			item.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
	}

	
	public void updateMember(String id, String pw) {
		 
		Connection con =null;
		PreparedStatement pst=null;
		String sql=" update acorntbl set pw =? where id = ? " ;
		try {
			con  =ds.getConnection();
			pst= con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);			
			pst.executeUpdate();			
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}
		
		close( pst, con);
		
	}
	  
	 

}
