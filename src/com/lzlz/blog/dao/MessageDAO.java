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
	 * ͨ�������ߺͷ�����ɾ����Ϣ
	 * 
	 * @param sendid
	 *            ������
	 * @param receiveid
	 *            ������
	 * @return �����
	 */
	public int deleteBySendOrRece(int sendid, int receiveid);

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

}
