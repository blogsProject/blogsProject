package com.lzlz.blog.entiy;

public class Message {
	private int mid;
	private int sendid;
	private int receiveid;
	private String sendname;// 不建列 只储存数据
	public Message() {
		super();
	}
	public Message(int mid, int sendid, int receiveid) {
		super();
		this.mid = mid;
		this.sendid = sendid;
		this.receiveid = receiveid;
	}
	public Message(int mid, int sendid, int receiveid, String sendname) {
		super();
		this.mid = mid;
		this.sendid = sendid;
		this.receiveid = receiveid;
		this.sendname = sendname;
	}
	public String getSendname() {
		return sendname;
	}
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public int getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(int receiveid) {
		this.receiveid = receiveid;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", sendid=" + sendid + ", receiveid=" + receiveid + "]";
	}
}
