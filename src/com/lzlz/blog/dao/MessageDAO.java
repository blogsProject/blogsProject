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
	 * 通过接受者和发送者删除信息
	 * 
	 * @param sendid
	 *            发送者
	 * @param receiveid
	 *            接受者
	 * @return 结果码
	 */
	public int deleteBySendOrRece(int sendid, int receiveid);

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

}
