package com.bigdata.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String msg = "";
		String path = "";
		HttpSession session = request.getSession();
		
		if(id == null || pwd == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		}
		
		if(id.equals("") || pwd.equals("")) {
			msg = "ID 또는 PW를 입력해주세요.";
			path = "/login";
		} else {
			
			if(id.equals("admin") && pwd.equals("1234")) {
				session.setAttribute("id", id);
				
			} else {
				msg = "ID 또는 PW가 틀렸습니다.";
				path = "/login";
			}
			
			
		}
		//setAttribute 사용해서 값을 넘김
		request.setAttribute("msg", msg);
		
		if(session.getAttribute("id") !=null) {
			response.sendRedirect("main");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
