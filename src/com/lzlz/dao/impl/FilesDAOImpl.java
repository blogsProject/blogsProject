package com.lzlz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.dao.FilesDAO;
import com.lzlz.entiy.Files;
import com.lzlz.util.CustomerUtil;
import com.lzlz.util.DBConnection;

public class FilesDAOImpl implements FilesDAO {

	@Override
	public int insertByFiles(Files files) {
		try {
			String sql = "insert files(fpath,ftype,uid) value(?,?,?)";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, files.getPath());
			pstmt.setString(2, files.getFtype());
			pstmt.setInt(3, files.getUid());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteByFid(int fid) {
		try {
			String sql = "delete from files where fid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			System.out.println(pstmt.toString());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Files> selectByUidWithType(int uid, boolean flag, int curpage, int count) {
		String type;
		if (flag)
			type = "Õº∆¨";
		else
			type = "“Ù¿÷";
		try {
			String sql = "select * from files where uid=? and flag=? limit ?,?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setString(2, type);
			pstmt.setInt(3, CustomerUtil.limitFristParmaWithMyql(curpage, count));
			pstmt.setInt(4, count);
			List<Files> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Files(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> selectFileNameByUid(int uid) {
		try {
			String sql = "select fpath from files where uid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			List<String> list = new ArrayList<>();
			while (rs.next()) {
				String path = rs.getString(1);
				list.add(path.substring(path.indexOf("/") + 1));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getAllPageByCountWithUid(int count, int uid) {
		return CustomerUtil.getAllCount(new DBConnection().getConnection(), "files", "uid=" + uid, count);
	}

}
