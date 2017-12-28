package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzlz.blog.entiy.Log;
import com.lzlz.blog.entiy.Page;
import com.lzlz.blog.service.LogService;
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
		if (flag.equals("home") || flag == null) {
			queryAll(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void insertByLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + logService.insertByLog(new Log(0, "洛天依", "天依殿下我爱你", null, 1, 0)));
	}

	protected void updateByLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + logService.updateByLog(new Log(1, "洛天依", "天依殿下我爱你爱你", null, 1, 0)));
	}

	protected void deleteByLid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + logService.deleteByLid(1));
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
		request.setAttribute("page", new Page(curpage, Allpage));
		System.out.println(((Page)request.getAttribute("page")).toString());
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
