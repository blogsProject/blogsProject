package com.zhangluping.dao;

import java.util.List;

import com.zhangluping.entiy.Log;

public interface LogDAO {
	public int insertByLog(Log log);

	public int deleteByLid(int lid);

	public int updateByLog(Log log);

	public Log getLogByLid(int lid);

	public List<Log> queryAll();

	public List<Log> queryByUid(int uid);

	public List<Log> queryWithReadNum();
}
