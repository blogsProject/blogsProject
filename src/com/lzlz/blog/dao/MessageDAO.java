package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Message;

public interface MessageDAO {
	/**
	 * ͨ��Message����һ������
	 * 
	 * @param message
	 *            Message���󼯺�
	 * @return �����
	 */
	public int insertByMessage(Message message);

	/**
	 * ͨ��midһ������
	 * 
	 * @param mid
	 *            ��Ϣ���
	 * @return �����
	 */
	public int deleteByMid(int mid);

	/**
	 * ͨ�������˻�ȡ���е�Message�ĸ���
	 * 
	 * @param receive
	 *            ������ID
	 * @return message�ĸ���
	 */
	public int getAllCountByReceiveId(int receive);

	/**
	 * ͨ�������˻�ȡ���е�Message����
	 * 
	 * @param receive
	 *            ������ID
	 * @param curpage
	 *            ��ǰҳ
	 * @param count
	 *            һҳ���ٸ�
	 * @return Message����
	 */
	public List<Message> selectByReceiveId(int receive);

	/**
	 * ͨ�������߻�ȡ��Ϣ��ҳ��
	 * 
	 * @param count
	 * @param receiveid
	 * @return ��ҳ��
	 */
	public int getPageByReceiveId(int count, int receiveid);
}
