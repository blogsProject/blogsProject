package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Reply;

public interface ReplyService {
	public int insertByReply(Reply reply);

	public int getAllCountByLid(int lid);
	
	public List<Reply> selectByLid(int lid, int curpage, int count);

	public int getPageByLid(int count, int lid);
}
