package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzlz.blog.service.FriendService;
import com.lzlz.blog.util.DAOFactory;

public class FriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendService friendService;

	public FriendController() {
		this.friendService = DAOFactory.getFriendService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
