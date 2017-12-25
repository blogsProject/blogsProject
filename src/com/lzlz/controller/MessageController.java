package com.lzlz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzlz.entiy.Message;
import com.lzlz.service.MessageService;
import com.lzlz.util.DAOFactory;

public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MessageService messageService;

	@Override
	public void init() throws ServletException {
		this.messageService = DAOFactory.getMessageService();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		deleteByMid(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void insertByMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + messageService.insertByMessage(new Message(0, 1, 2)));
	}

	protected void deleteByMid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("" + messageService.deleteByMid(1));
	}
}
