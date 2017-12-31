package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Message;

public interface MessageService {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
	
	public int deleteBySendOrRece(int sendid,int receiveid);
	
	public int getAllCountByReceiveId(int receive);

	public List<Message> selectByReceiveId(int receive);

	public int getPageByReceiveId(int count, int receiveid);
}
