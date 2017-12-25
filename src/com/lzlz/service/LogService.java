package com.lzlz.service;

import java.util.List;

import com.lzlz.entiy.Log;

public interface LogService {
	public int insertByLog(Log log);

	public int deleteByLid(int lid);

	public int updateByLog(Log log);

	public Log getLogByLid(int lid);

	public int getPageByCount(int count);

	public List<Log> queryAll(int curpage, int count);

	public List<Log> queryByUid(int uid, int curpage, int count);

	public List<Log> queryWithReadNum();
}
