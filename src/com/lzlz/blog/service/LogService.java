package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Log;

public interface LogService {
	/**
	 * 通过Log对象插入一条数据
	 * 
	 * @param log
	 *            Log对象的实例
	 * @return 结果码
	 */
	public int insertByLog(Log log);

	/**
	 * 通过日志编号删除一篇日志
	 * 
	 * @param lid
	 *            日志编号
	 * @return 结果码
	 */
	public int deleteByLid(int lid);

	/**
	 * 通过Log对象修改一条数据
	 * 
	 * @param log
	 *            Log对象的实例
	 * @return 结果码
	 */
	public int updateByLog(Log log);

	/**
	 * 对指定的日志增加一个阅读数
	 * 
	 * @param lid
	 *            日志ID
	 * @return 结果码
	 */
	public int updateByLidWhithReadNum(int lid);

	/**
	 * 通过日志编号获取Log对象
	 * 
	 * @param lid
	 *            日志编号
	 * @return Log对象的实例
	 */
	public Log getLogByLid(int lid);

	/**
	 * 通过用户id获取日志的个数
	 * 
	 * @param uid
	 *            用户id
	 * @return 日志的个数
	 */
	public int getAllCountByUid(int uid);

	/**
	 * 通过用户id获取日志列表的总页数
	 * 
	 * @param count
	 *            一页多少个
	 * @param uid
	 *            用户id
	 * @return 总页数
	 */
	public int getPageByCountWhithUid(int count, int uid);

	/**
	 * 获取所有日志的总个数
	 * 
	 * @return 总个数
	 */
	public int getAllCount();

	/**
	 * 获取所有日志的总页数
	 * 
	 * @param count
	 *            一页多少个
	 * @return 总页数
	 */
	public int getPageWhithAll(int count);

	/**
	 * 查询所有的日志集合
	 * 
	 * @param curpage
	 *            当前页
	 * @param count
	 *            一页多少个数
	 * @return 所有日志的集合
	 */
	public List<Log> queryAll(int curpage, int count);

	/**
	 * 通过uid查询所有日志集合
	 * 
	 * @param uid
	 *            用户编号
	 * @param curpage
	 * @param count
	 * @return
	 */
	public List<Log> queryByUid(int uid, int curpage, int count);

	/**
	 * 查询阅读数排名前十的日志
	 * 
	 * @return 日志集合
	 */
	public List<Log> queryWithReadNum();
}
