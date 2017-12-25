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
	public List<String> selectFileNameByUid(int uid) {
		return fileDAO.selectFileNameByUid(uid);
	}

	@Override
	public int getAllPageByCount(int count) {
		return fileDAO.getAllPageByCount(count);
	}

	@Override
	public List<Files> selectByUidWithType(int uid, boolean flag, int curpage, int count) {
		return fileDAO.selectByUidWithType(uid, flag, curpage, count);
	}

}
