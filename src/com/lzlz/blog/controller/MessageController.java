package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzlz.blog.entiy.Message;
import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.MessageService;
import com.lzlz.blog.util.DAOFactory;

public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MessageService messageService;

	@Override
	public void init() throws ServletException {
		this.messageService = DAOFactory.getMessageService();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null)
			response.sendRedirect("index.jsp");
		if (flag.equals("insert"))
			insertByMessage(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void insertByMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String receiveid = request.getParameter("receiveid");
		if (user == null || receiveid == null)
			System.out.println("¥¶¿Ì”Ôæ‰");
		int uid = user.getUid();
		response.getWriter()
				.write("" + messageService.insertByMessage(new Message(0, uid, Integer.valueOf(receiveid))));
	}

	protected void deleteByMid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + messageService.deleteByMid(1));
	}
}
