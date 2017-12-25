package com.lzlz.dao;

import java.util.List;

import com.lzlz.entiy.Files;

public interface FilesDAO {
	public int insertByFiles(Files files);

	public int deleteByFid(int fid);

	public List<Files> selectByUidWithType(int uid, boolean flag);

	public List<String> selectFileNameByUid(int uid);
}
