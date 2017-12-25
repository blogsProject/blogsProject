package com.lzlz.service;

import java.util.List;

import com.lzlz.entiy.Files;

public interface FilesService {
	public int insertByFiles(Files files);

	public int deleteByFid(int fid);

	public List<Files> selectByUidWithType(int uid, boolean flag);

	public List<String> selectFileNameByUid(int uid);
}
