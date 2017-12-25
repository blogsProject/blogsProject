package com.lzlz.service.impl;

import java.util.List;

import com.lzlz.dao.FriendDAO;
import com.lzlz.entiy.Friend;
import com.lzlz.service.FriendService;
import com.lzlz.util.DAOFactory;

public class FriendServiceImpl implements FriendService {
	private FriendDAO friendDAO;

	public FriendServiceImpl() {
		this.friendDAO = DAOFactory.getFriendDAO();
	}

	@Override
	public int insertByFriend(Friend friend) {
		return friendDAO.insertByFriend(friend);
	}

	@Override
	public int deleteBySecondId(int first, int second) {
		return friendDAO.deleteBySecondId(first, second);
	}

	@Override
	public List<Integer> selectByFirst(int curpage, int count) {
		return friendDAO.selectByFirst(curpage, count);
	}

	@Override
	public int getAllPageByFristByCount(int frist, int count) {
		return friendDAO.getAllPageByFristByCount(frist, count);
	}

}
