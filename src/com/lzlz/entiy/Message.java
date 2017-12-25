package com.lzlz.entiy;

public class Message {
	private int mid;
	private int sendid;
	private int receiveid;

	public Message() {
		super();
	}

	public Message(int mid, int sendid, int receiveid) {
		super();
		this.mid = mid;
		this.sendid = sendid;
		this.receiveid = receiveid;
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
