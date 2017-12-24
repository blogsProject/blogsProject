package com.zhangluping.entiy;

public class Reply {
	private int rid;
	private int lid;
	private String rcontent;
	private String rdate;

	public Reply() {
		super();
	}

	public Reply(int rid, int lid, String rcontent, String rdate) {
		super();
		this.rid = rid;
		this.lid = lid;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", lid=" + lid + ", rcontent=" + rcontent + ", rdate=" + rdate + "]";
	}

}
