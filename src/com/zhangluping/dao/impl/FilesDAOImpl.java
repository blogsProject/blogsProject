package com.zhangluping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zhangluping.dao.FilesDAO;
import com.zhangluping.entiy.Files;
import com.zhangluping.util.DBConnection;

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
	public int selectByUidWithType(int uid, boolean flag) {
		String type;
		if (flag)
			type = "Õº∆¨";
		else
			type = "“Ù¿÷";
		try {
			String sql = "select * from files where uid=? and flag=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setString(2, type);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
