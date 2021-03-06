package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzlz.blog.entiy.Friend;
import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.FriendService;
import com.lzlz.blog.service.MessageService;
import com.lzlz.blog.util.DAOFactory;

public class FriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendService friendService;
	private MessageService messageService;

	public FriendController() {
		this.friendService = DAOFactory.getFriendService();
		this.messageService = DAOFactory.getMessageService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null)
			response.sendRedirect("index.jsp");
		else if (flag.equals("success"))
			success(request, response);
		else if (flag.equals("deleteFriend"))
			deleteFriend(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 添加好友的业务逻辑
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void success(HttpServletRequest request, HttpServletResponse response)
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
		friendService.insertByFriend(new Friend(user.getUid(), Integer.valueOf(secondid_str)));
		friendService.insertByFriend(new Friend(Integer.valueOf(secondid_str),user.getUid()));
		messageService.deleteBySendOrRece(Integer.valueOf(secondid_str), user.getUid());
		request.setAttribute("flag", 8);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}
	/**
	 * 通过好友对象删除好友的业务逻辑
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteFriend(HttpServletRequest request, HttpServletResponse response)
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
		int secondid = Integer.valueOf(secondid_str);
		friendService.deleteBySecondId(user.getUid(), secondid);
		friendService.deleteBySecondId( secondid,user.getUid());
		request.setAttribute("ret", 10);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		return;
	}
}
