package com.lzlz.blog.entiy;

public class Reply {
	private int uid;
	private int lid;
	private String rcontent;
	private String rdatetime;
	private String username;// 不建列 只储存数据
	public Reply() {
		super();
	}
	public Reply(int uid, int lid, String rcontent, String rdate) {
		super();
		this.uid = uid;
		this.lid = lid;
		this.rcontent = rcontent;
		this.rdatetime = rdate;
	}
	public Reply(int uid, int lid, String rcontent, String rdatetime, String username) {
		super();
		this.uid = uid;
		this.lid = lid;
		this.rcontent = rcontent;
		this.rdatetime = rdatetime;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int rid) {
		this.uid = rid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRdatetime() {
		return rdatetime;
	}
	public void setRdatetime(String rdate) {
		this.rdatetime = rdate;
	}
	@Override
	public String toString() {
		return "Reply [uid=" + uid + ", lid=" + lid + ", rcontent=" + rcontent + ", rdatetime=" + rdatetime + "]";
	}

}
