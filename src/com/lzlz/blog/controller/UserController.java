package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.UserService;
import com.lzlz.blog.util.DAOFactory;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		this.userService = DAOFactory.getUserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("mod");
		if (flag.equals("regeist"))
			insertByUser(request, response);
		else if (flag.equals("login"))
			getUserByUsername(request, response);
	}

	protected void insertByUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(0, request.getParameter("username"), request.getParameter("password"),
				request.getParameter("netname"), request.getParameter("relname"), request.getParameter("gender"),
				request.getParameter("about"));
		response.getWriter().write("" + userService.insertByUser(user));
	}

	protected void getUserByUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userService.getUserByUsername(username);
		if (user == null)
			response.sendRedirect("");
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("").forward(request, response);
	}

	protected void updateByUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(1, request.getParameter("username"), request.getParameter("password"),
				request.getParameter("netname"), request.getParameter("relname"), request.getParameter("gender"),
				request.getParameter("about"));
		response.getWriter().write("" + userService.updateByUser(user));
	}

}
