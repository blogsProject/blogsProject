package com.zhangluping.service.impl;

import java.util.List;

import com.zhangluping.dao.ReplyDAO;
import com.zhangluping.entiy.Reply;
import com.zhangluping.service.ReplyService;
import com.zhangluping.util.DAOFactory;

public class ReplyServiceImpl implements ReplyService {

	private ReplyDAO replyDAO;

	public ReplyServiceImpl() {
		this.replyDAO = DAOFactory.getReplyDAO();
	}

	@Override
	public int insertByReply(Reply reply) {
		return replyDAO.insertByReply(reply);
	}

	@Override
	public List<Reply> selectByLid(int lid) {
		return replyDAO.selectByLid(lid);
	}

}
