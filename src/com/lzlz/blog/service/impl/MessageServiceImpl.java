package com.lzlz.blog.service.impl;

import java.util.List;

import com.lzlz.blog.dao.MessageDAO;
import com.lzlz.blog.entiy.Message;
import com.lzlz.blog.service.MessageService;
import com.lzlz.blog.util.DAOFactory;

public class MessageServiceImpl implements MessageService {

	private MessageDAO messageDAO;

	public MessageServiceImpl() {
		this.messageDAO = DAOFactory.getMessageDAO();
	}

	@Override
	public int insertByMessage(Message message) {
		return messageDAO.insertByMessage(message);
	}

	@Override
	public int deleteByMid(int mid) {
		return messageDAO.deleteByMid(mid);
	}

	@Override
	public List<Message> selectByReceive(int receive, int curpage, int count) {
		return messageDAO.selectByReceive(receive, curpage, count);
	}

	@Override
	public int getPageByReceive(int count, int receive) {
		return messageDAO.getPageByReceive(count, receive);
	}

}
