package com.acorn.day3.prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component

@Repository
public class AcornDAOEx4 {

	@Autowired
	DataSource ds;

	// 전체조회

	public List<Acorn> selectAll() {

		List<Acorn> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			String sql = "select * from  acorntbl";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				Acorn acorn = new Acorn();
				acorn.setId(rs.getString(1));
				acorn.setPw(rs.getString(2));
				acorn.setName(rs.getString(3));

				list.add(acorn);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 무조건 수행구문

			// close 순서는 거꾸로
			close(rs, pst, con);

		}

		return list;
	}

	// 한 개 조회
	// 등록
	// 변경
	// 삭제

	// 등록하기
	public int insert(Acorn acorn) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		int rowCnt = 0;
		try {
			con = ds.getConnection();
			String sql = "insert into acorntbl (id, pw, name) values (?, ?, ?)";
		
			pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getId());
			pst.setString(2, acorn.getPw());
			pst.setString(3, acorn.getName());
			
			rowCnt = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowCnt;
	}

	
	// 변경하기
	
	public int update(Map<String, String> map) {
		
		Connection con = null;
		PreparedStatement pst = null;
		
		
		int rowCnt = 0;
		try {
			con = ds.getConnection();
			String sql = "update acorntbl set pw=? where id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, map.get("pw"));
			pst.setString(2, map.get("id"));
			
			rowCnt = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst, con);
		}
		
		
		return rowCnt;
	}
	
	// 삭제
	
	public int delete (String id) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int rowCnt = 0;
		try {
			con = ds.getConnection();
			String sql = "delete from acorntbl where id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			rowCnt = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		return rowCnt;
	}
	
	
	private void close(AutoCloseable... autoCloseables) { // 가변인자

		for (AutoCloseable item : autoCloseables) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Acorn selectOne(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Acorn acorn = null;

		try {
			con = ds.getConnection();
			String sql = "select * from acorntbl where id = ?";

			pst.setString(1, sql);
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				acorn = new Acorn();

				acorn.setId(rs.getString(1));
				acorn.setPw(rs.getString(2));
				acorn.setName(rs.getString(3));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acorn;
	}

}
