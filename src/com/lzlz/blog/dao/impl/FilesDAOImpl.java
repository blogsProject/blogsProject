package com.lzlz.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.blog.dao.FilesDAO;
import com.lzlz.blog.entiy.Files;
import com.lzlz.blog.util.CustomerUtil;
import com.lzlz.blog.util.DBConnection;

public class FilesDAOImpl implements FilesDAO {

	@Override
	public int insertByFiles(Files files) {
		try {
			String sql = "insert files(fpath,ftype,uid) value(?,?,?)";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, files.getFpath());
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
			String sql = "select * from files where uid=? and ftype=? limit ?,?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setString(2, type);
			pstmt.setInt(3, CustomerUtil.limitFristParmaWithMyql(curpage, count));
			pstmt.setInt(4, count);
			List<Files> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String fpath = rs.getString(2);
				String fnameIncludeExtern = fpath.substring(fpath.indexOf('/') + 1);
				String fnameNoExtern = fnameIncludeExtern.substring(0, fnameIncludeExtern.lastIndexOf('.'));
				list.add(new Files(rs.getInt(1), fnameNoExtern, fpath, rs.getString(3), rs.getInt(4)));
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
		return CustomerUtil.getPage(count, getAllCountByUid(uid));
	}

	@Override
	public int getAllCountByUid(int uid) {
		try {
			String sql = "select count(*) from files where uid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Files> selectByUidWithTypeNoFenye(int uid, boolean flag) {
		String type;
		if (flag)
			type = "Õº∆¨";
		else
			type = "“Ù¿÷";
		try {
			String sql = "select * from files where uid=? and ftype=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setString(2, type);
			List<Files> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String fpath = rs.getString(2);
				String fnameIncludeExtern = fpath.substring(fpath.indexOf('/') + 1);
				String fnameNoExtern = fnameIncludeExtern.substring(0, fnameIncludeExtern.lastIndexOf('.'));
				list.add(new Files(rs.getInt(1), fnameNoExtern, fpath, rs.getString(3), rs.getInt(4)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Files selectFileByFid(int fid) {
		try {
			String sql = "select * from files where fid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String fpath = rs.getString(2);
				String fnameIncludeExtern = fpath.substring(fpath.indexOf('/') + 1);
				String fnameNoExtern = fnameIncludeExtern.substring(0, fnameIncludeExtern.lastIndexOf('.'));
				Files file = new Files(rs.getInt(1), fnameNoExtern, fpath, rs.getString(3), rs.getInt(4));
				return file;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
