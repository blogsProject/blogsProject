package com.zhangluping.service;

import java.util.List;

import com.zhangluping.entiy.User;

public interface UserService {
	public int insertByUser(User user);

	public User getUserByUsername(String username);

	public User getUserByUid(int uid);

	public int updateByUser(User user);

	public List<User> queryAll();

}
