package com.lzlz.service;

import java.util.List;

import com.lzlz.entiy.Files;

public interface FilesService {
	public int insertByFiles(Files files);

	public int deleteByFid(int fid);
	
	public int getAllPageByCountWithUid(int count,int uid);

	public List<Files> selectByUidWithType(int uid, boolean flag,int curpage,int count);

	public List<String> selectFileNameByUid(int uid);
}
