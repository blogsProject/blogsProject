package com.zhangluping.dao;

import java.util.List;

import com.zhangluping.entiy.Reply;

public interface ReplyDAO {
	public int insertByReply(Reply reply);

	public List<Reply> selectByLid(int lid);

}
