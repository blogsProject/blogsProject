package com.zhangluping.dao;

import java.util.List;

import com.zhangluping.entiy.Friend;

public interface FriendsDAO {
	public int insertByFriend();

	public int deleteByFriend();

	public List<Friend> selectByFirst();
}
