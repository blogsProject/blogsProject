package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Reply;

public interface ReplyDAO {
	/**
	 * 通过Reply插入一条数据
	 * 
	 * @param reply
	 *            Reply的对象实例
	 * @return 结果码
	 */
	public int insertByReply(Reply reply);

	/**
	 * 通过日志ID查询所有评论的总个数
	 * 
	 * @param lid
	 *            日志id
	 * @return 总个数
	 */
	public int getAllCountByLid(int lid);

	/**
	 * 通过日志id查询所有评论
	 * 
	 * @param lid
	 *            日志id
	 * @param curpage
	 *            当前页
	 * @param count
	 *            一页多少个
	 * @return 评论集合
	 */
	public List<Reply> selectByLid(int lid, int curpage, int count);

	/**
	 * 通过日志id获取总页数
	 * 
	 * @param count
	 *            一页多少个
	 * @param lid
	 *            日志id
	 * @return 总页数
	 */
	public int getPageByLid(int count, int lid);
}
