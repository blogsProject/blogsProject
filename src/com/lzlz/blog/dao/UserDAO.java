package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.User;

public interface UserDAO {
	/**
	 * ͨ��User�������һ������
	 * 
	 * @param user
	 *            User����ʵ��
	 * @return �����
	 */
	public int insertByUser(User user);

	/**
	 * ͨ���û�����ȡUser����
	 * 
	 * @param username
	 *            �û���
	 * @return User����
	 */
	public User getUserByUsername(String username);

	/**
	 * ͨ��uid��ȡUser����
	 * 
	 * @param uid
	 *            �û����
	 * @return User����
	 */
	public User getUserByUid(int uid);

	/**
	 * ͨ��User����������һ������
	 * 
	 * @param user
	 *            User����ʵ��
	 * @return �����
	 */
	public int updateByUser(User user);

	/**
	 * ͨ���û�ID�ļ��ϲ�ѯ
	 * 
	 * @param listid
	 *            �û�ID�ļ���
	 * @return �û����󼯺�
	 */
	public List<User> queryByList(List<Integer> listid);

	/**
	 * ��ѯ�����û�
	 * 
	 * @return �����û�����
	 */
	public List<User> queryAll();

}
