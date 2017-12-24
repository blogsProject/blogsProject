package com.zhangluping.service.impl;

import com.zhangluping.dao.FilesDAO;
import com.zhangluping.entiy.Files;
import com.zhangluping.service.FilesService;
import com.zhangluping.util.DAOFactory;

public class FilesServiceImpl implements FilesService {
	private FilesDAO fileDAO;

	public FilesServiceImpl() {
		this.fileDAO = DAOFactory.getFilesDAO();
	}

	@Override
	public int insertByFiles(Files files) {
		return fileDAO.insertByFiles(files);
	}

	@Override
	public int deleteByFid(int fid) {
		return fileDAO.deleteByFid(fid);
	}

	@Override
	public int selectByUidWithType(int uid, boolean flag) {
		return fileDAO.selectByUidWithType(uid, flag);
	}

}
