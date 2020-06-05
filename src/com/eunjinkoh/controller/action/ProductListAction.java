package com.eunjinkoh.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.ProductDAO;
import com.eunjinkoh.dto.ProductVO;

public class ProductListAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "/products/productList.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductVO> list = pDao.selectAllList();
		
		request.setAttribute("productList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
