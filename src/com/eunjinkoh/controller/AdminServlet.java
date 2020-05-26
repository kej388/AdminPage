package com.eunjinkoh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eunjinkoh.dao.AdminDAO;
import com.eunjinkoh.dto.AdminVO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminLogin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url = "index.jsp";
		
		String adminemail = request.getParameter("adminemail");
		String adminpass = request.getParameter("adminpass");
		
		AdminDAO aDao = AdminDAO.getInstance();
		int result = aDao.adminCheck(adminemail, adminpass);
		
		if(result == 1) {
			AdminVO aVo = aDao.getAdmin(adminemail);
			HttpSession session = request.getSession();
			session.setAttribute("adminLoginUser", aVo);
			url = "dashboard/dashboard.jsp";
		} else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지않습니다.");
		} else if(result == -1) {
			request.setAttribute("message", "이메일이 맞지않습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
