package com.zhangluping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangluping.entiy.Reply;
import com.zhangluping.service.ReplyService;
import com.zhangluping.util.DAOFactory;

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
		selectByLid(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void insertByReply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + replyService.insertByReply(new Reply(1, 1, "ÃÏ“¿µÓœ¬Œ“∞Æƒ„", null)));
	}

	protected void selectByLid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + replyService.selectByLid(1));
	}
}
