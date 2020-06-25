package com.eunjinkoh.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.MovieDAO;
import com.eunjinkoh.dto.MovieVO;

public class MovieListAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/movie/movieList.jsp";
	
		MovieDAO mDao = MovieDAO.getInstance();
		List<MovieVO> list = mDao.getListMovie();
		
		System.out.println("..ddfdffddf");
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
