package com.lzlz.service.impl;

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

}
