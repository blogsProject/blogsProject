package com.lzlz.blog.dao;

import java.util.List;

import com.lzlz.blog.entiy.Friend;

public interface FriendDAO {
	/**
	 * 通过Friend插入一条数据
	 * 
	 * @param friend
	 * @return 返回插入结果
	 */
	public int insertByFriend(Friend friend);

	/**
	 * 通过好友的ID和主人的ID删除一条记录
	 * 
	 * @param first
	 *            second 主人ID 好友ID
	 * @return 返回删除结果
	 */
	public int deleteBySecondId(int first, int second);

	/**
	 * 通过主人ID查询second集合
	 * 
	 * @param curpage
	 *            当前页
	 * @param count
	 *            多少个一页
	 * @return 查询的集合
	 */
	public List<Integer> selectByFirst(int first);

	/**
	 * 通过first和count获取总页数
	 * 
	 * @param count
	 *            frist 多少个一页 主人编号
	 * @return 总页数
	 */
	public boolean friendIsHave(int firstid,int secondid);
}
