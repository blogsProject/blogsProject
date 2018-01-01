package com.lzlz.blog.service;

import java.util.List;

import com.lzlz.blog.entiy.Files;

public interface FilesService {
	public int insertByFiles(Files files);

	public int deleteByFid(int fid);

	public Files selectFileByFid(int fid);

	public List<Files> selectByUidWithTypeNoFenye(int uid, boolean flag);

	public List<String> selectFileNameByUid(int uid);

}
