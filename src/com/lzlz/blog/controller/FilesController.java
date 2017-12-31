package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.FilesService;
import com.lzlz.blog.util.DAOFactory;
import com.lzlz.blog.util.FileProcess;

import net.sf.json.JSONObject;

public class FilesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilesService filesService;

	@Override
	public void init() throws ServletException {
		this.filesService = DAOFactory.getFilesService();
	}

	public FilesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null)
			response.sendRedirect("index.jsp");
		if (flag.equals("music"))
			queryFileByUidWhithType(request, response);
		else if (flag.equals("all"))
			queryAllByLid(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileProcess.uploadProcess(request, response, filesService, true, 1);
	}

	protected void queryFileByUidWhithType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 4);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		int uid = Integer.valueOf(user.getUid());
		boolean type = Boolean.valueOf(request.getParameter("type"));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileList", filesService.selectByUidWithTypeNoFenye(uid, type));
		response.getWriter().write(jsonObject.toString());
	}

	protected void queryAllByLid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 4);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		int uid = Integer.valueOf(user.getUid());
		request.setAttribute("imglist", filesService.selectByUidWithTypeNoFenye(uid, true));
		request.setAttribute("musiclist", filesService.selectByUidWithTypeNoFenye(uid, false));
		System.out.println("------------------------");
		request.getRequestDispatcher("File.jsp").forward(request, response);
	}
}
