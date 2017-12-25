package com.lzlz.dao;

import com.lzlz.entiy.Message;

public interface MessageDAO {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
}
