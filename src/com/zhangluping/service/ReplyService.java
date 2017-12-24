package com.zhangluping.service;

import java.util.List;

import com.zhangluping.entiy.Reply;

public interface ReplyService {
	
	public int insertByReply(Reply reply);

	public List<Reply> selectByLid(int lid);

}
