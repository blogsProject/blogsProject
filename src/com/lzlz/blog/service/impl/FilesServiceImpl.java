package com.lzlz.blog.service.impl;

import java.util.List;

import com.lzlz.blog.dao.FilesDAO;
import com.lzlz.blog.entiy.Files;
import com.lzlz.blog.service.FilesService;
import com.lzlz.blog.util.DAOFactory;

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
	public int getAllPageByCountWithUid(int count, int uid) {
		return fileDAO.getAllPageByCountWithUid(count, uid);
	}

	@Override
	public List<Files> selectByUidWithType(int uid, boolean flag, int curpage, int count) {
		return fileDAO.selectByUidWithType(uid, flag, curpage, count);
	}

	@Override
	public int getAllCountByUid(int uid) {
		return fileDAO.getAllCountByUid(uid);
	}

	@Override
	public List<Files> selectByUidWithTypeNoFenye(int uid, boolean flag) {
		return fileDAO.selectByUidWithTypeNoFenye(uid, flag);
	}

}
