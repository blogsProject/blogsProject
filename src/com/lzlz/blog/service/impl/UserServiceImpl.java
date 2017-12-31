package com.lzlz.blog.service.impl;

import java.util.List;

import com.lzlz.blog.dao.UserDAO;
import com.lzlz.blog.entiy.User;
import com.lzlz.blog.service.UserService;
import com.lzlz.blog.util.DAOFactory;

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

	@Override
	public List<User> queryByList(List<Integer> listid) {
		// TODO Auto-generated method stub
		return userDao.queryByList(listid);
	}

}
