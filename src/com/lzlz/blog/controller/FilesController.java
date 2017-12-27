package com.lzlz.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzlz.blog.entiy.Files;
import com.lzlz.blog.service.FilesService;
import com.lzlz.blog.util.DAOFactory;
import com.lzlz.blog.util.FileProcess;

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
		StringBuffer sb = new StringBuffer();
		for(Files f :filesService.selectByUidWithType(1, true, 1, 5))
			sb.append(f.toString()+"<br>");
		response.getWriter().write(""+sb);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileProcess.uploadProcess(request, response, filesService, true, 1);
	}

}
