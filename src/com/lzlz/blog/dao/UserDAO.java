package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.User;

public interface UserDAO {
	public int insertByUser(User user);

	public User getUserByUsername(String username);

	public User getUserByUid(int uid);

	public int updateByUser(User user);

	public List<User> queryByList(List<Integer> listid);

	public List<User> queryAll();

}
