package com.lzlz.service.impl;

import java.util.List;

import com.lzlz.dao.MessageDAO;
import com.lzlz.entiy.Message;
import com.lzlz.service.MessageService;
import com.lzlz.util.DAOFactory;

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
