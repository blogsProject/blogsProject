package com.lzlz.blog.service.impl;

import java.util.List;

import com.lzlz.blog.dao.FriendDAO;
import com.lzlz.blog.entiy.Friend;
import com.lzlz.blog.service.FriendService;
import com.lzlz.blog.util.DAOFactory;

public class FriendServiceImpl implements FriendService {
	private FriendDAO friendDAO;

	public FriendServiceImpl() {
		this.friendDAO = DAOFactory.getFriendDAO();
	}

	@Override
	public int insertByFriend(Friend friend) {
		// TODO Auto-generated method stub
		return friendDAO.insertByFriend(friend);
	}

	@Override
	public int deleteBySecondId(int first, int second) {
		// TODO Auto-generated method stub
		return friendDAO.deleteBySecondId(first, second);
	}

	@Override
	public List<Integer> selectByFirst(int first) {
		// TODO Auto-generated method stub
		return friendDAO.selectByFirst(first);
	}

	@Override
	public boolean friendIsHave(int firstid, int secondid) {
		// TODO Auto-generated method stub
		return friendDAO.friendIsHave(firstid, secondid);
	}

}
