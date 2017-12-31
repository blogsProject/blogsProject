package com.lzlz.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzlz.blog.entiy.Files;
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
		if (flag.equals("music"))
			queryFileByUidWhithType(request, response);
		else if (flag.equals("all"))
			queryAllByLid(request, response);
		else if (flag.equals("download"))
			downFileByFid(request, response);
		else if (flag.equals("photo"))
			photo(request, response);
		else if (flag.equals("delete"))
			deleteById(request, response);
		else {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("请通过正确方式访问该页面");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null)
			insertByFile(request, response);
	}

	protected void queryFileByUidWhithType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int ret = 0;
		User user = (User) session.getAttribute("user");
		if (user == null) {
			ret = 0;
			response.getWriter().write("" + ret);
			return;
		}
		int uid = Integer.valueOf(user.getUid());
		boolean type = Boolean.valueOf(request.getParameter("type"));
		JSONObject jsonObject = new JSONObject();
		List<Files> list = filesService.selectByUidWithTypeNoFenye(uid, type);
		if(list.isEmpty())
			ret = 1;
		jsonObject.put("fileList", filesService.selectByUidWithTypeNoFenye(uid, type));
		jsonObject.put("ret", ret);
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
		request.setAttribute("flag", true);
		request.getRequestDispatcher("File.jsp").forward(request, response);
	}

	protected void downFileByFid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 4);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		String fid_str = request.getParameter("fid");
		if (fid_str == null) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		Files file = filesService.selectFileByFid(Integer.valueOf(fid_str));
		if (file == null || file.getUid() != user.getUid()) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		FileProcess.downloadProcess(request, response, file);
	}

	protected void insertByFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 4);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		System.out.println("--------------------------------");
		FileProcess.uploadProcess(request, response, filesService, user.getUid());
	}

	protected void photo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 4);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		System.out.println("----------");
		request.setAttribute("plist", filesService.selectByUidWithTypeNoFenye(user.getUid(), true));
		request.setAttribute("flag", true);
		request.getRequestDispatcher("photo.jsp").forward(request, response);
	}

	protected void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("ret", 4);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		String fid_str = request.getParameter("fid");
		if (fid_str == null) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		int fid = Integer.valueOf(fid_str);
		Files file = filesService.selectFileByFid(fid);
		if (file.getUid() != user.getUid()) {
			request.setAttribute("ret", 5);
			request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
			return;
		}
		filesService.deleteByFid(fid);
		FileProcess.remove(request,file.getFpath());
		request.setAttribute("ret", 10);
		request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
	}
}
