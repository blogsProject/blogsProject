package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Log;

public interface LogService {
	public int insertByLog(Log log);

	public int deleteByLid(int lid);

	public int updateByLog(Log log);

	public Log getLogByLid(int lid);

	public int getPageByCountWhithUid(int count,int uid);

	public List<Log> queryAll(int curpage, int count);

	public List<Log> queryByUid(int uid, int curpage, int count);

	public List<Log> queryWithReadNum();
}