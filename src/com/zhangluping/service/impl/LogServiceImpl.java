package com.zhangluping.service.impl;

import java.util.List;

import com.zhangluping.dao.LogDAO;
import com.zhangluping.entiy.Log;
import com.zhangluping.service.LogService;
import com.zhangluping.util.DAOFactory;

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
	public List<Log> queryAll() {
		return logDAO.queryAll();
	}

	@Override
	public List<Log> queryByUid(int uid) {
		return logDAO.queryByUid(uid);
	}

	@Override
	public List<Log> queryWithReadNum() {
		return logDAO.queryWithReadNum();
	}

}
