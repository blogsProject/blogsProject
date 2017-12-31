package com.lzlz.blog.util;

import java.util.List;

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
	private static final String[] MUSICSTR = { "mp3", "ogg", "wam" };
	private static final String[] IMGSTR = { "png", "jpg", "gif" };

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

	/**
	 * 判断文件是否在数据库里存在 如果存在就加上 (数字) 参照window命名规则
	 * 
	 * @param fileold
	 *            原来的文件名
	 * @param filename
	 *            更改后的文件名 注:调用这个方法的时候fileold和filename要一样
	 * @param fileNamelist
	 *            需要判断的文件字符串集合
	 * @param count
	 *            数字从几开始 默认从1开始
	 * @return 修改后的文件名或者未修改的文件名(假如这个文件名不存在)
	 */
	public static String filenameIsExist(String fileold, String filename, List<String> fileNamelist, int count) {
		if (count <= 0)
			count = 1;
		if (!fileNamelist.contains(filename))
			return filename;
		return filenameIsExist(fileold, fileold + "(" + count++ + ")", fileNamelist, count);
	}

	public static int isImageOrMusic(String fileExternName) {
		for (int i = 0; i < IMGSTR.length; i++) {
			if (IMGSTR[i].equals(fileExternName))
				return 1;
		}
		for (int i = 0; i < MUSICSTR.length; i++) {
			if (MUSICSTR[i].equals(fileExternName))
				return 2;
		}
		return 3;
	}
}
