package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Files;

public interface FilesDAO {
	/**
	 * 通过Files对下插入一条数据
	 * 
	 * @param files
	 *            Files对象实例
	 * @return 结果码
	 */
	public int insertByFiles(Files files);

	/**
	 * 通过fid删除一个文件
	 * 
	 * @param fid
	 *            文件编号
	 * @return 结果码
	 */
	public int deleteByFid(int fid);

	/**
	 * 通过用户的ID来获取Files类
	 * 
	 * @param fid
	 *            文件编号
	 * @return 文件实体类
	 */
	public Files selectFileByFid(int fid);

	/**
	 * 不分页的查询
	 * 
	 * @param uid
	 *            用户编号
	 * @return 文件集合
	 */
	public List<Files> selectByUidWithTypeNoFenye(int uid, boolean flag);

	/**
	 * 通过用户id查询文件名的集合
	 * 
	 * @param uid
	 *            用户id
	 * @return 文件名集合
	 */
	public List<String> selectFileNameByUid(int uid);

	/**
	 * 通过用户id获取所有文件的个数
	 * 
	 * @param uid
	 *            用户id
	 * @return 文件个数
	 */
	public int getAllCountByUid(int uid);
}
