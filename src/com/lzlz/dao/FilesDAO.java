package com.lzlz.dao;

import java.util.List;

import com.lzlz.entiy.Files;

public interface FilesDAO {
	public int insertByFiles(Files files);

	public int deleteByFid(int fid);
	
	public int getAllPageByCount(int count);

	public List<Files> selectByUidWithType(int uid, boolean flag,int curpage,int count);

	public List<String> selectFileNameByUid(int uid);
}
