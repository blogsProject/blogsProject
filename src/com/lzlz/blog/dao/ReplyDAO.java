package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Reply;

public interface ReplyDAO {
	public int insertByReply(Reply reply);

	public List<Reply> selectByLid(int lid, int curpage, int count);

	public int getPageByLid(int count, int lid);
}
