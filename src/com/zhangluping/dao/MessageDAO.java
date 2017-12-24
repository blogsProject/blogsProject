package com.zhangluping.dao;

import com.zhangluping.entiy.Message;

public interface MessageDAO {
	public int insertByMessage(Message message);

	public int deleteByMid(int mid);
}
