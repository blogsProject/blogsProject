package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Logs;

import com.lzlz.blog.entiy.Log;
import com.lzlz.blog.entiy.Page;
import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.LogService;
import com.lzlz.blog.util.CustomerUtil;
import com.lzlz.blog.util.DAOFactory;

public class LogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LogService logService;

	@Override
	public void init() throws ServletException {
		this.logService = DAOFactory.getLogService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null || flag == "") {
			response.sendRedirect("index.jsp");
			return;
		}
		if (flag.equals("home") || flag == null)
			queryAll(request, response);
		else if (flag.equals("insert"))
			insertByLog(request, response);
		else if (flag.equals("update"))
			updateByLog(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void insertByLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 1);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}
		String ltitle = request.getParameter("ltitle");
		String lcontent = request.getParameter("lcontent");
		if (CustomerUtil.isNullStringArr(ltitle, lcontent)) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}
		Log log = new Log(0, ltitle, lcontent, null, user.getUid(), 0);
		logService.insertByLog(log);
		request.setAttribute("ret", 8);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}

	protected void updateByLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 1);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}
		String ltitle = request.getParameter("ltitle");
		String lcontent = request.getParameter("lcontent");
		if (CustomerUtil.isNullStringArr(ltitle, lcontent)) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}
		Log log = new Log(Integer.valueOf(request.getParameter("lid")), ltitle, lcontent, null, user.getUid(), 0);
		logService.updateByLog(log);
		request.setAttribute("ret", 9);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}

	protected void deleteByLid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 1);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}
		String lid_str = request.getParameter("lid");

		if (CustomerUtil.isNullStringArr(lid_str)) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}
		int lid = Integer.valueOf(lid_str);
		Log log = logService.getLogByLid(lid);
		if (log == null) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}

		if (log.getUid() != user.getUid()) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
		}

		request.setAttribute("ret", 10);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}

	protected void getLogByLid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + logService.getLogByLid(1));
	}

	protected void queryAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curpage = Integer.valueOf(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		int Allpage = logService.getPageWhithAll(5);
		request.setAttribute("AlllogList", logService.queryAll(curpage, 5));
		request.setAttribute("readList", logService.queryWithReadNum());
		Page page = new Page(curpage, Allpage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void queryByUid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curpage = Integer.valueOf(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		int Allpage = logService.getPageWhithAll(5);
		request.setAttribute("AlllogList", logService.queryAll(curpage, 5));
		request.setAttribute("page", new Page(curpage, Allpage));
		
	}

	protected void queryWithReadNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		for (Log log : logService.queryWithReadNum()) {
			sb.append(log);
		}
		response.getWriter().write("" + sb.toString());
	}
}
