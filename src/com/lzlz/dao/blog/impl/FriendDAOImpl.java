package com.lzlz.dao.blog.impl;

import java.util.List;

import com.lzlz.blog.dao.FriendDAO;
import com.lzlz.blog.entiy.Friend;

public class FriendDAOImpl implements FriendDAO {
	
	@Override
	public int insertByFriend(Friend friend) {
		return 0;
	}

	@Override
	public int deleteBySecondId(int first, int second) {
		return 0;
	}

	@Override
	public List<Integer> selectByFirst(int curpage, int count) {
		return null;
	}

	@Override
	public int getAllPageByFristByCount(int frist, int count) {
		return 0;
	}

}
