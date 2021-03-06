package com.lzlz.blog.service.impl;

import java.util.List;

import com.lzlz.blog.dao.LogDAO;
import com.lzlz.blog.entiy.Log;
import com.lzlz.blog.service.LogService;
import com.lzlz.blog.util.DAOFactory;

public class LogServiceImpl implements LogService {
	private LogDAO logDAO;

	public LogServiceImpl() {
		this.logDAO = DAOFactory.getLogDAO();
	}

	@Override
	public int insertByLog(Log log) {
		return logDAO.insertByLog(log);
	}

	@Override
	public int deleteByLid(int lid) {
		return logDAO.deleteByLid(lid);
	}

	@Override
	public int updateByLog(Log log) {
		return logDAO.updateByLog(log);
	}

	@Override
	public Log getLogByLid(int lid) {
		return logDAO.getLogByLid(lid);
	}

	@Override
	public List<Log> queryAll(int curpage, int count) {
		return logDAO.queryAll(curpage, count);
	}

	@Override
	public List<Log> queryByUid(int uid) {
		return logDAO.queryByUid(uid);
	}

	@Override
	public List<Log> queryWithReadNum() {
		return logDAO.queryWithReadNum();
	}

	@Override
	public int getPageByCountWhithUid(int count, int uid) {
		return logDAO.getPageByCountWhithUid(count, uid);
	}

	@Override
	public int getAllCountByUid(int uid) {
		return logDAO.getAllCountByUid(uid);
	}

	@Override
	public int updateByLidWhithReadNum(int lid) {
		return logDAO.updateByLidWhithReadNum(lid);
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return logDAO.getAllCount();
	}

	@Override
	public int getPageWhithAll(int count) {
		// TODO Auto-generated method stub
		return logDAO.getPageWhithAll(count);
	}

}
