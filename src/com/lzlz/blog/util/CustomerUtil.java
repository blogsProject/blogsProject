package com.lzlz.blog.util;

import java.util.List;

public class CustomerUtil {
	/**
	 * �����ҳ��ѯʽ��limit�ĵ�һ������ �� limit ?(�������),?;
	 * 
	 * @param curpage
	 *            ��ǰҳ��
	 * @param count
	 *            һ�β���ٸ�
	 * @return ������ȷ�Ĳ���
	 */
	private static final String[] MUSICSTR = { "mp3", "ogg", "wam" };
	private static final String[] IMGSTR = { "png", "jpg", "gif" };

	public static int limitFristParmaWithMyql(int curpage, int count) {
		return curpage * count - count;
	}

	/**
	 * ������ҳ��
	 * 
	 * @param count
	 *            һ�β���ٸ�
	 * @param allCount
	 *            �ܸ���
	 * @return
	 */
	public static int getPage(int count, int allCount) {
		return (allCount % count == 0 ? allCount / count : allCount / count + 1);
	}

	/**
	 * �жϴ���������ַ����Ƿ���nullֵ
	 * 
	 * @param str
	 *            ��ѡ����
	 * @return ��null����true û�з���false
	 */
	public static boolean isNullStringArr(String... str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == null)
				return true;
		}
		return false;
	}

	/**
	 * �ж��ļ��Ƿ������ݿ������ ������ھͼ��� (����) ����window��������
	 * 
	 * @param fileold
	 *            ԭ�����ļ���
	 * @param filename
	 *            ���ĺ���ļ��� ע:�������������ʱ��fileold��filenameҪһ��
	 * @param fileNamelist
	 *            ��Ҫ�жϵ��ļ��ַ�������
	 * @param count
	 *            ���ִӼ���ʼ Ĭ�ϴ�1��ʼ
	 * @return �޸ĺ���ļ�������δ�޸ĵ��ļ���(��������ļ���������)
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
