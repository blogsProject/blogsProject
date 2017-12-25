package com.lzlz.service.impl;

import java.util.List;

import com.lzlz.dao.FilesDAO;
import com.lzlz.entiy.Files;
import com.lzlz.service.FilesService;
import com.lzlz.util.DAOFactory;

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
	public List<Files> selectByUidWithType(int uid, boolean flag) {
		return fileDAO.selectByUidWithType(uid, flag);
	}

	@Override
	public List<String> selectFileNameByUid(int uid) {
		return fileDAO.selectFileNameByUid(uid);
	}

}
