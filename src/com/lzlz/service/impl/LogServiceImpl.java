package com.lzlz.service.impl;

import java.util.List;

import com.lzlz.dao.LogDAO;
import com.lzlz.entiy.Log;
import com.lzlz.service.LogService;
import com.lzlz.util.DAOFactory;

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
	public List<Log> queryByUid(int uid, int curpage, int count) {
		return logDAO.queryByUid(uid, curpage, count);
	}

	@Override
	public List<Log> queryWithReadNum() {
		return logDAO.queryWithReadNum();
	}

	@Override
	public int getPageByCountWhithUid(int count,int uid) {
		return logDAO.getPageByCountWhithUid(count,uid);
	}

}
