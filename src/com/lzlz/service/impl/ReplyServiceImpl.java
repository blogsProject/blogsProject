package com.lzlz.service.impl;

import java.util.List;

import com.lzlz.dao.ReplyDAO;
import com.lzlz.entiy.Reply;
import com.lzlz.service.ReplyService;
import com.lzlz.util.DAOFactory;

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
	public List<Reply> selectByLid(int lid, int curpage, int count) {
		return replyDAO.selectByLid(lid, curpage, count);
	}

	@Override
	public int getPageByLid(int count, int lid) {
		return replyDAO.getPageByLid(count, lid);
	}


}
