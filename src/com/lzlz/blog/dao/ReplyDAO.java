package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Reply;

public interface ReplyDAO {
	/**
	 * ͨ��Reply����һ������
	 * 
	 * @param reply
	 *            Reply�Ķ���ʵ��
	 * @return �����
	 */
	public int insertByReply(Reply reply);

	/**
	 * ͨ����־ID��ѯ�������۵��ܸ���
	 * 
	 * @param lid
	 *            ��־id
	 * @return �ܸ���
	 */
	public int getAllCountByLid(int lid);

	/**
	 * ͨ����־id��ѯ��������
	 * 
	 * @param lid
	 *            ��־id
	 * @param curpage
	 *            ��ǰҳ
	 * @param count
	 *            һҳ���ٸ�
	 * @return ���ۼ���
	 */
	public List<Reply> selectByLid(int lid, int curpage, int count);

	/**
	 * ͨ����־id��ȡ��ҳ��
	 * 
	 * @param count
	 *            һҳ���ٸ�
	 * @param lid
	 *            ��־id
	 * @return ��ҳ��
	 */
	public int getPageByLid(int count, int lid);
}
