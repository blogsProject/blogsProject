package com.zhangluping.service;

import com.zhangluping.entiy.Files;

public interface FilesService {
	public int insertByFiles(Files files);

	public int deleteByFid(int fid);

	public int selectByUidWithType(int uid, boolean flag);
}
