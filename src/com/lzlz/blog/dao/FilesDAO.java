package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Files;

public interface FilesDAO {
	/**
	 * ͨ��Files���²���һ������
	 * 
	 * @param files
	 *            Files����ʵ��
	 * @return �����
	 */
	public int insertByFiles(Files files);

	/**
	 * ͨ��fidɾ��һ���ļ�
	 * 
	 * @param fid
	 *            �ļ����
	 * @return �����
	 */
	public int deleteByFid(int fid);

	/**
	 * ͨ���û���ID����ȡFiles��
	 * 
	 * @param fid
	 *            �ļ����
	 * @return �ļ�ʵ����
	 */
	public Files selectFileByFid(int fid);

	/**
	 * ����ҳ�Ĳ�ѯ
	 * 
	 * @param uid
	 *            �û����
	 * @return �ļ�����
	 */
	public List<Files> selectByUidWithTypeNoFenye(int uid, boolean flag);

	/**
	 * ͨ���û�id��ѯ�ļ����ļ���
	 * 
	 * @param uid
	 *            �û�id
	 * @return �ļ�������
	 */
	public List<String> selectFileNameByUid(int uid);

	/**
	 * ͨ���û�id��ȡ�����ļ��ĸ���
	 * 
	 * @param uid
	 *            �û�id
	 * @return �ļ�����
	 */
	public int getAllCountByUid(int uid);
}
