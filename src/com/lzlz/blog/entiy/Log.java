package com.lzlz.blog.entiy;

public class Log {
	private int lid;
	private String ltitle;
	private String lcontent;
	private String ltime;
	private int uid;
	private int readnum;

	public Log() {
		super();
	}

	public Log(int lid, String ltitle, String lcontent, String ltime, int uid, int readnum) {
		super();
		this.lid = lid;
		this.ltitle = ltitle;
		this.lcontent = lcontent;
		this.ltime = ltime;
		this.uid = uid;
		this.readnum = readnum;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLtitle() {
		return ltitle;
	}

	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}

	public String getLcontent() {
		return lcontent;
	}

	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	@Override
	public String toString() {
		return "Log [lid=" + lid + ", ltitle=" + ltitle + ", lcontent=" + lcontent + ", ltime=" + ltime + ", uid=" + uid
				+ ", readnum=" + readnum + "]";
	}

}
