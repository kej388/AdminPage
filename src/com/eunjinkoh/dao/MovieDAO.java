package com.eunjinkoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eunjinkoh.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	private MovieDAO(){}
	
	private static MovieDAO instance = new MovieDAO();
	public static MovieDAO getInstance() {
		return instance;
	}
	
	// 영화 리스트
	public List<MovieVO> getListMovie() {
		String sql = "select * from movie order by code desc";
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO mVo = new MovieVO();
				
				mVo.setCode(rs.getInt("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setActor(rs.getString("actor"));
				mVo.setDirector(rs.getString("director"));
				mVo.setPoster(rs.getString("poster"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setSynopsis(rs.getString("synopsis"));
				
				list.add(mVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	// 영화 등록
	public void insertMovie(MovieVO mVo) {
		String sql = "insert into movie values(SEQ_MOVIE.nextval, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVo.getTitle());
			pstmt.setInt(2, mVo.getPrice());
			pstmt.setString(3, mVo.getDirector());
			pstmt.setString(4, mVo.getActor());
			pstmt.setString(5, mVo.getPoster());
			pstmt.setString(6, mVo.getSynopsis());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 
	
}
