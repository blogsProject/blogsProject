package com.lzlz.blog.entiy;

/**
 * 储存数据的类 不建立表
 * @author MIKU
 *
 */
public class Page {
	private int curpage;
	private int allPage;
	public Page() {
		super();
	}
	public Page(int curpage, int allPage) {
		super();
		this.curpage = curpage;
		this.allPage = allPage;
	}
	public int getCurpage() {
		return curpage;
	}
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	@Override
	public String toString() {
		return "Page [curpage=" + curpage + ", allPage=" + allPage + "]";
	}
}
