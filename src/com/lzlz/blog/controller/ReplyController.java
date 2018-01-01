package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzlz.blog.entiy.Page;
import com.lzlz.blog.entiy.Reply;
import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.LogService;
import com.lzlz.blog.service.ReplyService;
import com.lzlz.blog.util.DAOFactory;

public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService replyService;
	private LogService logService;

	@Override
	public void init() throws ServletException {
		this.replyService = DAOFactory.getReplyService();
		this.logService = DAOFactory.getLogService();
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
		else if (flag.equals("insertByReply"))
			insertByReply(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 添加评论的业务逻辑
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertByReply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String lid = request.getParameter("lid");
		String rcontent = request.getParameter("rcontent");
		if(user == null){
			request.setAttribute("ret", 4);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		if (lid == null || rcontent == null) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		replyService.insertByReply(new Reply(user.getUid(), Integer.valueOf(lid), rcontent, null));
		request.setAttribute("ret", 12);
		request.setAttribute("lid", Integer.valueOf(lid));
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}
	/**
	 * 通过日志ID查询评论的业务逻辑
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectByLid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String lid_str = request.getParameter("lid");
		String curpage_str = request.getParameter("curpage");
		int curpage = Integer.valueOf(curpage_str == null ? "1" : curpage_str);
		if (user == null || lid_str == null) {
			return;
		}
		int lid = Integer.valueOf(curpage);
		request.setAttribute("logobj", logService.getLogByLid(lid));
		request.setAttribute("replyList", replyService.selectByLid(lid, curpage, 5));
		request.setAttribute("page", new Page(curpage, replyService.getPageByLid(5, lid)));
		request.getRequestDispatcher("bloginfo.jsp").forward(request, response);
	}
}
