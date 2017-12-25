package com.lzlz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzlz.entiy.User;
import com.lzlz.service.UserService;
import com.lzlz.util.DAOFactory;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		this.userService = DAOFactory.getUserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("请使用正确的方式访问该路径");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int mod = Integer.parseInt(request.getParameter("mod"));
		switch (mod) {
		case 1:
			insertByUser(request, response);
			break;
		case 2:
			getUserByUsername(request, response);
			break;
		case 3:
			updateByUser(request, response);
			break;
		case 4:
			queryAll(request, response);
			break;
		default:
			response.getWriter().write("访问方式错误");
		}
	}

	protected void insertByUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(0, request.getParameter("username"), request.getParameter("password"),
				request.getParameter("netname"), request.getParameter("relname"), request.getParameter("gender"),
				request.getParameter("about"));
		System.out.println(user);
		System.out.println(userService);
		response.getWriter().write("" + userService.insertByUser(user));
	}

	protected void getUserByUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userService.getUserByUsername(username);
		response.getWriter().write("" + user);
	}

	protected void updateByUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(1, request.getParameter("username"), request.getParameter("password"),
				request.getParameter("netname"), request.getParameter("relname"), request.getParameter("gender"),
				request.getParameter("about"));
		response.getWriter().write("" + userService.updateByUser(user));
	}

	protected void queryAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		for (User user : userService.queryAll()) {
			sb.append(user);
		}
		response.getWriter().write("" + sb.toString());
	}
}
