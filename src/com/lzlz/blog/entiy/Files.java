package com.lzlz.blog.entiy;

public class Files {
	private int fid;
	// 不在数据库里建表 只是单纯的储存文件名(不包括扩展名)
	private String fname;
	private String fpath;
	private String ftype;
	private int uid;

	// -----
	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Files(int fid, String fname, String path, String ftype, int uid) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fpath = path;
		this.ftype = ftype;
		this.uid = uid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String path) {
		this.fpath = path;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Files [fid=" + fid + ", fname=" + fname + ", fpath=" + fpath + ", ftype=" + ftype + ", uid=" + uid + "]";
	}

}
