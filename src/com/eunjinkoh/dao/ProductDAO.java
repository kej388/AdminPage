package com.eunjinkoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eunjinkoh.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	private ProductDAO() {}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	// 상품리스트
	public List<ProductVO> selectAllList() {
		String sql = "SELECT * FROM product ORDER BY product_code DESC";
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pVo = new ProductVO();
				pVo.setProduct_code(rs.getInt("product_code"));
				pVo.setProduct_name(rs.getString("product_name"));
				pVo.setProduct_price(rs.getInt("product_price"));
				pVo.setProduct_pictureurl(rs.getString("product_pictureurl"));
				pVo.setProduct_description(rs.getString("product_description"));
				list.add(pVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	/* ------------------ 상품등록 -----------------------*/
	public void insertProduct(ProductVO pVo) {
		String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getProduct_name());
			pstmt.setInt(2, pVo.getProduct_price());
			pstmt.setString(3, pVo.getProduct_pictureurl());
			pstmt.setString(4, pVo.getProduct_description());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
