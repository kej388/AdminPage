package com.eunjinkoh.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.ProductDAO;

public class ProductDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductDAO pDao = ProductDAO.getInstance();
		
		pDao.deleteProduct(code);
		
		response.sendRedirect("/AdminPage/ProductServlet?command=product_list_action");
		
	}

}
