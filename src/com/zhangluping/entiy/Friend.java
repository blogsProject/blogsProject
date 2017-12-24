package com.zhangluping.entiy;

public class Friend {
	private int first;
	private int second;

	public Friend() {
		super();
	}

	public Friend(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Friend [first=" + first + ", second=" + second + "]";
	}

}
