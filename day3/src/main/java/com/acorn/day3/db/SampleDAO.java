package com.acorn.day3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleDAO {

	@Autowired
	DataSource  ds;	
	//회원등록
	
	public int  insertUser(  String id, String pw) {			
		int resultRow=0;
		Connection con=null;
		PreparedStatement  pst= null;		
		
		try {
			String sql="insert into sampletbl values( ?,?)" ;
			con  = ds.getConnection();
			pst  = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			resultRow =pst.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		 /*	if( pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if( con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			*/
		   close( pst, con);
		}		
		return  resultRow;
	}	
	
	public ArrayList<User> select() {		
		String sql="select * from member_tbl_11";
		Connection con =null;
		PreparedStatement  pst =null;
		ResultSet rs = null;
		
		
		ArrayList<User> list  = new ArrayList<>();
		try {
			 con = ds.getConnection();
		     pst =con.prepareStatement(sql);
			 rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				User user = new User();
				user.setId(rs.getString(1));
				user.setPw(rs.getString(2));
				
				list.add(user);
			}  
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}
		finally {
			close( rs, pst, con);
		}
		return list;
	}
		
	
	private void  close(AutoCloseable ... acs) {		
		for( AutoCloseable ac: acs) {
			if( ac !=null)
				try {
					ac.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	
}
