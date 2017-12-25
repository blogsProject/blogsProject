package com.lzlz.dao;

import java.util.List;

import com.lzlz.entiy.Message;

public interface MessageDAO {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
	
	public List<Message> selectByReceive(int receive,int curpage,int count);
	
	public int getPageByReceive(int count,int receive);
}
