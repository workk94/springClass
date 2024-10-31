package com.acorn.prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AcornDAO {
	
	@Autowired
	DataSource ds;
	
	//전체조회
	public ArrayList<Acorn> selectAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Acorn> list= new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String sql = "select * from acorntbl";
			
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Acorn acorn = new Acorn();
				acorn.setId(rs.getString(1));
				acorn.setPw(rs.getString(2));
				acorn.setName(rs.getString(3));
				
				list.add(acorn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		
		return list;
	}
	
	//조회
	public Acorn selectOne(String name) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Acorn acorn = null;
		
		try {
			con = ds.getConnection();
			String sql = "select * from acorntbl where name = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()) {
				acorn = new Acorn();
				acorn.setId(rs.getString(1));
				acorn.setPw(rs.getString(2));
				acorn.setName(rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rs, pst, con);
		}
		
		
		
		return acorn;
	}
	
	//삽입
	public int insert(Map<String, String> map) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rowCnt = 0; // 0 이면 실패 
		try {
			con = ds.getConnection();
			String sql = "insert into acorntbl (id, pw, name) values (?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, map.get("id"));
			pst.setString(2, map.get("pw"));
			pst.setString(3, map.get("name"));
			
			rowCnt = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst, con);
		}
		
		
		return rowCnt;
		
	}
	
	
	//수정 
	public int update(String name) {
		Connection con= null;
		PreparedStatement pst = null;
		
		try {
			con = ds.getConnection();
			String sql = "";
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	
	public void close (AutoCloseable... autoCloseables) {
		for(AutoCloseable item : autoCloseables) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
