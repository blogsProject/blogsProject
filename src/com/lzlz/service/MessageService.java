package com.lzlz.service;

import com.lzlz.entiy.Message;

public interface MessageService {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
}
