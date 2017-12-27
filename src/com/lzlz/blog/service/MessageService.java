package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Message;

public interface MessageService {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
	
	public int getAllCountByReceiveId(int receive);
	
	public List<Message> selectByReceiveId(int receive,int curpage,int count);
	
	public int getPageByReceiveId(int count,int receiveid);
}
