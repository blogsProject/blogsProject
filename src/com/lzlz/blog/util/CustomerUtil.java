package com.lzlz.blog.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUtil {
	public static int limitFristParmaWithMyql(int curpage, int count) {
		return curpage * count - count;
	}

	public static int getPage(int count, int allCount) {
		return (allCount % count == 0 ? allCount / count : allCount / count + 1);
	}

}
