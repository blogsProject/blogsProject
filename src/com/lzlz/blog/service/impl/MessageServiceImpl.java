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
	public List<Message> selectByReceiveId(int receiveid) {
		return messageDAO.selectByReceiveId(receiveid);
	}

	@Override
	public int getPageByReceiveId(int count, int receiveid) {
		return messageDAO.getPageByReceiveId(count, receiveid);
	}

	@Override
	public int getAllCountByReceiveId(int receiveid) {
		return messageDAO.getAllCountByReceiveId(receiveid);
	}

	@Override
	public int deleteBySendOrRece(int sendid, int receiveid) {
		return 0;
	}

}
