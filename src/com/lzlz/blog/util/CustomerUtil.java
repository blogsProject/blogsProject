package com.lzlz.blog.util;

public class CustomerUtil {
	/**
	 * 计算分页查询式的limit的第一个参数 即 limit ?(就是这个),?;
	 * 
	 * @param curpage
	 *            当前页数
	 * @param count
	 *            一次查多少个
	 * @return 返回正确的参数
	 */
	public static int limitFristParmaWithMyql(int curpage, int count) {
		return curpage * count - count;
	}

	/**
	 * 计算总页数
	 * 
	 * @param count
	 *            一次查多少个
	 * @param allCount
	 *            总个数
	 * @return
	 */
	public static int getPage(int count, int allCount) {
		return (allCount % count == 0 ? allCount / count : allCount / count + 1);
	}

	/**
	 * 判断传入进来的字符串是否有null值
	 * 
	 * @param str
	 *            多选参数
	 * @return 有null返回true 没有返回false
	 */
	public static boolean isNullStringArr(String... str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == null)
				return true;
		}
		return false;
	}
}
