package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Log;

public interface LogService {
	/**
	 * ͨ��Log�������һ������
	 * 
	 * @param log
	 *            Log�����ʵ��
	 * @return �����
	 */
	public int insertByLog(Log log);

	/**
	 * ͨ����־���ɾ��һƪ��־
	 * 
	 * @param lid
	 *            ��־���
	 * @return �����
	 */
	public int deleteByLid(int lid);

	/**
	 * ͨ��Log�����޸�һ������
	 * 
	 * @param log
	 *            Log�����ʵ��
	 * @return �����
	 */
	public int updateByLog(Log log);

	/**
	 * ��ָ������־����һ���Ķ���
	 * 
	 * @param lid
	 *            ��־ID
	 * @return �����
	 */
	public int updateByLidWhithReadNum(int lid);

	/**
	 * ͨ����־��Ż�ȡLog����
	 * 
	 * @param lid
	 *            ��־���
	 * @return Log�����ʵ��
	 */
	public Log getLogByLid(int lid);

	/**
	 * ͨ���û�id��ȡ��־�ĸ���
	 * 
	 * @param uid
	 *            �û�id
	 * @return ��־�ĸ���
	 */
	public int getAllCountByUid(int uid);

	/**
	 * ͨ���û�id��ȡ��־�б����ҳ��
	 * 
	 * @param count
	 *            һҳ���ٸ�
	 * @param uid
	 *            �û�id
	 * @return ��ҳ��
	 */
	public int getPageByCountWhithUid(int count, int uid);

	/**
	 * ��ȡ������־���ܸ���
	 * 
	 * @return �ܸ���
	 */
	public int getAllCount();

	/**
	 * ��ȡ������־����ҳ��
	 * 
	 * @param count
	 *            һҳ���ٸ�
	 * @return ��ҳ��
	 */
	public int getPageWhithAll(int count);

	/**
	 * ��ѯ���е���־����
	 * 
	 * @param curpage
	 *            ��ǰҳ
	 * @param count
	 *            һҳ���ٸ���
	 * @return ������־�ļ���
	 */
	public List<Log> queryAll(int curpage, int count);

	/**
	 * ͨ��uid��ѯ������־����
	 * 
	 * @param uid
	 *            �û����
	 * @param curpage
	 * @param count
	 * @return
	 */
	public List<Log> queryByUid(int uid, int curpage, int count);

	/**
	 * ��ѯ�Ķ�������ǰʮ����־
	 * 
	 * @return ��־����
	 */
	public List<Log> queryWithReadNum();
}
