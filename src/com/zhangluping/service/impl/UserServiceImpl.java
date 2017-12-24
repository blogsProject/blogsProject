package com.zhangluping.service.impl;

import java.util.List;

import com.zhangluping.dao.UserDAO;
import com.zhangluping.entiy.User;
import com.zhangluping.service.UserService;
import com.zhangluping.util.DAOFactory;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;

	public UserServiceImpl() {
		this.userDao = DAOFactory.getUserDAO();
	}

	@Override
	public int insertByUser(User user) {
		return userDao.insertByUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public int updateByUser(User user) {
		return userDao.updateByUser(user);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public User getUserByUid(int uid) {
		// TODO Auto-generated method stub
		return userDao.getUserByUid(uid);
	}

}
