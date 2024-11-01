package com.acon.prac4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemFormDAO {
	
	@Autowired
	DataSource ds;
	
	
	// 전체 조회
	public List<ItemForm> selectAll() {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ItemForm> list = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String sql = "select * from itemtbl";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ItemForm form = new ItemForm();
				form.setItemId(rs.getString(1));
				form.setItemName(rs.getString(2));
				
				list.add(form);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		
		
		return list;
	}
	
	
	// 삽입 
	public int insert(String id, String name) {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pst = null; 
		
		try {
			
			con = ds.getConnection();
			String sql = "INSERT INTO itemtbl (id, name) values(? , ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, name);
			
			rowCnt = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst, con);
		}
		
		return rowCnt;
	}
	
	private void close(AutoCloseable... autoCloseables) {
		for(AutoCloseable item :  autoCloseables) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
