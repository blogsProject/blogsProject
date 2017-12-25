package com.lzlz.blog.entiy;

public class Files {
	private int fid;
	private String path;
	private String ftype;
	private int uid;
//-----
	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Files(int fid, String path, String ftype, int uid) {
		super();
		this.fid = fid;
		this.path = path;
		this.ftype = ftype;
		this.uid = uid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
		return "Files [fid=" + fid + ", path=" + path + ", ftype=" + ftype + ", uid=" + uid + "]";
	}

}
