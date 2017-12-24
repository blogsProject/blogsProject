package com.zhangluping.service.impl;

import com.zhangluping.dao.MessageDAO;
import com.zhangluping.entiy.Message;
import com.zhangluping.service.MessageService;
import com.zhangluping.util.DAOFactory;

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
