package com.zhangluping.dao;

import com.zhangluping.entiy.Files;

public interface FilesDAO {
	public int insertByFiles(Files files);

	public int deleteByFid(int fid);

	public int selectByUidWithType(int uid, boolean flag);

}
