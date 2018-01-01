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
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null)
			response.sendRedirect("index.jsp");
		if (flag.equals("insertfriend"))
			insertByMessage(request, response);
		else if (flag.equals("delete"))
			delete(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 添加好友申请的业务逻辑
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertByMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String secondid = request.getParameter("secondid");
		if (user == null || secondid == null) {
			request.setAttribute("flag", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		messageService.insertByMessage(new Message(0, user.getUid(), Integer.valueOf(secondid)));
		request.setAttribute("ret", 11);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}
	/**
	 * 删除好友申请的业务逻辑
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 1);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}

		String secondid_str = request.getParameter("secondid");
		if (secondid_str == null) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		messageService.deleteBySendOrRece(Integer.valueOf(secondid_str), user.getUid());
		messageService.deleteBySendOrRece(user.getUid(), Integer.valueOf(secondid_str));
		request.setAttribute("ret", 10);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}
}
