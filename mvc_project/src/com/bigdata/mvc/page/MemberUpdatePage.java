package com.bigdata.mvc.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata.mvc.dao.MemberDAO;
import com.bigdata.mvc.vo.MemberVO;

/**
 * Servlet implementation class UpdatePage
 */
public class MemberUpdatePage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		MemberVO mvo = dao.selectOne(id);
		request.setAttribute("mvo", mvo);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/member_update.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
