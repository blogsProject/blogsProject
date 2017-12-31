package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Friend;

public interface FriendDAO {
	/**
	 * ͨ��Friend����һ������
	 * 
	 * @param friend
	 * @return ���ز�����
	 */
	public int insertByFriend(Friend friend);

	/**
	 * ͨ�����ѵ�ID�����˵�IDɾ��һ����¼
	 * 
	 * @param first
	 *            second ����ID ����ID
	 * @return ����ɾ�����
	 */
	public int deleteBySecondId(int first, int second);

	/**
	 * ͨ������ID��ѯsecond����
	 * 
	 * @param curpage
	 *            ��ǰҳ
	 * @param count
	 *            ���ٸ�һҳ
	 * @return ��ѯ�ļ���
	 */
	public List<Integer> selectByFirst(int first);

	/**
	 * ͨ��first��count��ȡ��ҳ��
	 * 
	 * @param count
	 *            frist ���ٸ�һҳ ���˱��
	 * @return ��ҳ��
	 */
	public boolean friendIsHave(int firstid,int secondid);
}
