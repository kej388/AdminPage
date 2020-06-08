package com.eunjinkoh.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.ProductDAO;
import com.eunjinkoh.dto.ProductVO;

public class ProductUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/products/productUpdateForm.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		String code = request.getParameter("code");
		ProductVO pVo = pDao.oneSelectProduct(code);
		
		request.setAttribute("product", pVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
