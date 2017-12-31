package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Message;

public interface MessageDAO {
	/**
	 * 通过Message插入一条数据
	 * 
	 * @param message
	 *            Message对象集合
	 * @return 结果码
	 */
	public int insertByMessage(Message message);

	/**
	 * 通过mid一条数据
	 * 
	 * @param mid
	 *            信息编号
	 * @return 结果码
	 */
	public int deleteByMid(int mid);

	/**
	 * 通过接收人获取所有的Message的个数
	 * 
	 * @param receive
	 *            接受者ID
	 * @return message的个数
	 */
	public int getAllCountByReceiveId(int receive);

	/**
	 * 通过接收人获取所有的Message集合
	 * 
	 * @param receive
	 *            接受者ID
	 * @param curpage
	 *            当前页
	 * @param count
	 *            一页多少个
	 * @return Message集合
	 */
	public List<Message> selectByReceiveId(int receive);

	/**
	 * 通过接受者获取信息总页数
	 * 
	 * @param count
	 * @param receiveid
	 * @return 总页数
	 */
	public int getPageByReceiveId(int count, int receiveid);
}
