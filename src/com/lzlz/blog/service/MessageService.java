package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Message;

public interface MessageService {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
	
	public List<Message> selectByReceive(int receive,int curpage,int count);
	
	public int getPageByReceive(int count,int receive);
}
