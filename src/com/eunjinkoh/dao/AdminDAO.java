package com.eunjinkoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.eunjinkoh.dto.AdminVO;

import util.DBManager;

public class AdminDAO {
	private AdminDAO() {};
	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	
	// 회원 인증 시 check 메소드
	public int adminCheck(String adminemail, String adminpass) {
		int result = -1;
		String sql = "SELECT adminpass FROM adminlogin WHERE adminemail=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminemail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("adminpass").equals(adminpass)) {
					return result = 1;
				} else {
					return result = 0;
				}
			} else {
				return result;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 회원 정보 가져오는 메소드
	public AdminVO getAdmin(String adminemail) {
		String sql = "SELECT * FROM adminlogin WHERE adminemail=?";
		
		AdminVO aVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminemail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				aVo = new AdminVO();
				aVo.setAdminEmail(rs.getString("adminemail"));
				aVo.setAdminName(rs.getString("adminname"));
				aVo.setAdminPass(rs.getString("adminpass"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return aVo;
	}
}
