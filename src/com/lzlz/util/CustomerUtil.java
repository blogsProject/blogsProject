package com.lzlz.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUtil {
	public static int limitFristParmaWithMyql(int curpage, int count) {
		return curpage * count - count;
	}

	public static int getPage(int count, int allCount) {
		return allCount % count == 0 ? allCount / count : allCount / count + 1;
	}

	public static int getAllCount(Connection conn, String tablename, int count) {
		try {
			String sql = "Select count(*) from " + tablename;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int countAll = rs.getInt(1);
			if (pstmt != null)
				pstmt.close();
			return CustomerUtil.getPage(count, countAll);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 1;
	}
}
