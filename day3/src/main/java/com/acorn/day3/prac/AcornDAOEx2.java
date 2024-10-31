package com.acorn.day3.prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component

@Repository
public class AcornDAOEx2 {

	@Autowired
	DataSource  ds;
	
	
	
	// 전체조회
	 
	public List<Acorn>  selectAll(){
		
		List<Acorn> list = new ArrayList<>();
		
		
		Connection con= null ;
		PreparedStatement pst=null;
		ResultSet  rs=null;
		
		try {
			con  =ds.getConnection();
			String sql ="select * from  acorntbl";			
			pst  = con.prepareStatement(sql);
			rs  =pst.executeQuery();
				
			while( rs.next()) {
				
				Acorn acorn  = new Acorn( );
				acorn.setId( rs.getString(1));
				acorn.setPw(rs.getString(2));
				acorn.setName(rs.getString(3));
				
				list.add(acorn);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {   // 무조건 수행구문 
			
			 // close  순서는  거꾸로 		 
		 close( rs, pst, con);			
			
		}
		
		
		
		return list;		
	}
	
	// 한 개 조회
	// 등록
	// 변경
	// 삭제 
	
	
	
	
	private void close( AutoCloseable a1,AutoCloseable a2) {
		if( a1 != null)
			try {
				a1.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		if( a2 != null) {
			try {
				a2.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void close( AutoCloseable a1,AutoCloseable a2, AutoCloseable a3 )  {
		
		if( a1 != null) {
			try {
				a1.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if( a2 != null) {
			try {
				a2.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if( a3 != null) {
			try {
				a3.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	 }
	
	
	
}
