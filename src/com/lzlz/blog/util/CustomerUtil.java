package com.lzlz.blog.util;

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

}
