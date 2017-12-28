package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzlz.blog.entiy.Reply;
import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.ReplyService;
import com.lzlz.blog.util.DAOFactory;

public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService replyService;

	@Override
	public void init() throws ServletException {
		this.replyService = DAOFactory.getReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null)
			response.sendRedirect("index.jsp");
		if (flag.equals("insert"))
			insertByReply(request, response);
		else if (flag.equals("select"))
			selectByLid(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void insertByReply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String lid = request.getParameter("lid");
		String rcontent = request.getParameter("rcontent");
		if (user == null || lid == null || rcontent == null)
			System.out.println("处理语句");
		response.getWriter()
				.write("" + replyService.insertByReply(new Reply(user.getUid(), Integer.valueOf(lid), rcontent, null)));
	}

	protected void selectByLid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String lid = request.getParameter("lid");
		String curpage_str = request.getParameter("curpage");
		curpage_str = curpage_str == null ? "1" : curpage_str;
		if (user == null || lid == null)
			System.out.println("处理语句");
		response.getWriter()
				.write("" + replyService.selectByLid(Integer.valueOf(lid), Integer.valueOf(curpage_str), 5));
	}
}
