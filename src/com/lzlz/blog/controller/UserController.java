package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.FriendService;
import com.lzlz.blog.service.LogService;
import com.lzlz.blog.service.MessageService;
import com.lzlz.blog.service.UserService;
import com.lzlz.blog.util.CustomerUtil;
import com.lzlz.blog.util.DAOFactory;
import com.mysql.jdbc.Messages;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private LogService logService;
	private MessageService messageService;
	private FriendService friendService;

	@Override
	public void init() throws ServletException {
		this.userService = DAOFactory.getUserService();
		this.logService = DAOFactory.getLogService();
		this.messageService = DAOFactory.getMessageService();
		this.friendService = DAOFactory.getFriendService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag.equals("regeist"))
			insertByUser(request, response);
		else if (flag.equals("login"))
			getUserByUsername(request, response);
		else if (flag.equals("checkUsername"))
			checkUsername(request, response);
		else if (flag.equals("single"))
			single(request, response);
	}

	protected void insertByUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(0, request.getParameter("username"), request.getParameter("password"),
				request.getParameter("netname"), request.getParameter("relname"), request.getParameter("gender"),
				request.getParameter("about"));
		int ret = 0;
		if (userService.insertByUser(user) == 1) {
			ret = 1;
		}
		request.setAttribute("ret", ret);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}

	protected void getUserByUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.getUserByUsername(username);
		if (user == null) {
			request.setAttribute("ret", 7);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		if (!password.equals(user.getPassword())) {
			request.setAttribute("ret", 2);
			return;
		}
		request.getSession().setAttribute("user", user);
		request.setAttribute("ret", 3);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void updateByUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null)
			response.sendRedirect("");
		String uid = request.getParameter("uid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String netname = request.getParameter("netname");
		String relname = request.getParameter("relname");
		String gender = request.getParameter("gender");
		String about = request.getParameter("about");
		if (CustomerUtil.isNullStringArr(uid, username, password, netname, relname, gender, about))
			System.out.println("处理语句");
		else if (user.getUid() != Integer.valueOf(uid))
			System.out.println("处理语句");
		User newuser = new User(Integer.valueOf(uid), username, password, netname, relname, gender, about);
		response.getWriter().write("" + userService.updateByUser(newuser));
	}

	protected void checkUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userService.getUserByUsername(username);
		if (username == null)
			response.getWriter().write("" + 3);
		else if (user == null) {
			response.getWriter().write("" + 1);
		} else
			response.getWriter().write("" + 2);
	}

	protected void single(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 1);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}
		request.setAttribute("messagelist", messageService.selectByReceiveId(user.getUid()));
		request.setAttribute("friendlist", friendService.selectByFirst(user.getUid()));
		request.setAttribute("loglist", logService.queryByUid(user.getUid()));
		request.setAttribute("flag", true);
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}
}
