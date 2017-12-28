package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.User;

public interface UserDAO {
	/**
	 * 通过User对象插入一条数据
	 * 
	 * @param user
	 *            User对象实例
	 * @return 结果码
	 */
	public int insertByUser(User user);

	/**
	 * 通过用户名获取User对象
	 * 
	 * @param username
	 *            用户名
	 * @return User对象
	 */
	public User getUserByUsername(String username);

	/**
	 * 通过uid获取User对象
	 * 
	 * @param uid
	 *            用户编号
	 * @return User对象
	 */
	public User getUserByUid(int uid);

	/**
	 * 通过User对象来更新一条数据
	 * 
	 * @param user
	 *            User对象实例
	 * @return 结果码
	 */
	public int updateByUser(User user);

	/**
	 * 通过用户ID的集合查询
	 * 
	 * @param listid
	 *            用户ID的集合
	 * @return 用户对象集合
	 */
	public List<User> queryByList(List<Integer> listid);

	/**
	 * 查询所有用户
	 * 
	 * @return 所有用户集合
	 */
	public List<User> queryAll();

}
