package com.zhangluping.service;

import com.zhangluping.entiy.Message;

public interface MessageService {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
}
