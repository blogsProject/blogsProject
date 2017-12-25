package com.lzlz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzlz.entiy.Log;
import com.lzlz.service.LogService;
import com.lzlz.util.DAOFactory;

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
		queryWithReadNum(request, response);
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
		StringBuffer sb = new StringBuffer();
		for (Log log : logService.queryAll(1, 5)) {
			sb.append(log);
		}
		response.getWriter().write("" + sb.toString());
	}

	protected void queryByUid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		for (Log log : logService.queryByUid(1, 1, 5)) {
			sb.append(log);
		}
		response.getWriter().write("" + sb.toString());
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
