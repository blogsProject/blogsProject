package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Message;

public interface MessageService {
	public int insertByMessage(Message message);

	public int deleteBySendOrRece(int sendid, int receiveid);

	public List<Message> selectByReceiveId(int receive);

}
