package com.eunjinkoh.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.ProductDAO;
import com.eunjinkoh.dto.ProductVO;

public class ProductUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO pDao = ProductDAO.getInstance();
		
		ProductVO pVo = new ProductVO();
		pVo.setProduct_name(request.getParameter("name"));
		pVo.setProduct_price(Integer.parseInt(request.getParameter("price")));
		pVo.setProduct_pictureurl(request.getParameter("pictureurl"));
		pVo.setProduct_description(request.getParameter("description"));
		pVo.setProduct_code(Integer.parseInt(request.getParameter("code")));
		
		pDao.updateProduct(pVo);
		
		response.sendRedirect("/AdminPage/ProductServlet?command=product_list_action");
		
	}

}