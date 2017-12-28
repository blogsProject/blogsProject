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
		if (request.getSession().getAttribute("user") == null)
			response.sendRedirect("index.jsp");
		String flag = request.getParameter("flag");
		if (flag.equals("music"))
			queryFileByUidWhithType(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileProcess.uploadProcess(request, response, filesService, true, 1);
	}

	protected void queryFileByUidWhithType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			response.getWriter().write(1);
		int uid = Integer.valueOf(((User) session.getAttribute("user")).getUid());
		boolean type = Boolean.valueOf(request.getParameter("type"));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileList", filesService.selectByUidWithTypeNoFenye(uid, type));
		response.getWriter().write(jsonObject.toString());
	}
}
