package com.lzlz.blog.entiy;

public class Friend {
	private int first;
	private int second;
	private String firendName;

	public Friend() {
		super();
	}

	public Friend(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	public Friend(int first, int second, String firendName) {
		super();
		this.first = first;
		this.second = second;
		this.firendName = firendName;
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

	public String getFirendName() {
		return firendName;
	}

	public void setFirendName(String firendName) {
		this.firendName = firendName;
	}

	@Override
	public String toString() {
		return "Friend [first=" + first + ", second=" + second + "]";
	}

}
