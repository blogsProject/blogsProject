package com.zhangluping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhangluping.dao.LogDAO;
import com.zhangluping.entiy.Log;
import com.zhangluping.util.DBConnection;

public class LogDAOImpl implements LogDAO {

	@Override
	public int insertByLog(Log log) {
		try {
			String sql = "insert log(ltitle,lcontent,ltime,uid,readnum) value(?,?,now(),?,?)";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, log.getLtitle());
			pstmt.setString(2, log.getLcontent());
			pstmt.setInt(3, log.getUid());
			pstmt.setInt(4, log.getReadnum());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteByLid(int lid) {
		try {
			String sql = "delete from log where lid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			System.out.println(pstmt.toString());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByLog(Log log) {
		try {
			String sql = "update log set ltitle=?,lcontent=? where lid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, log.getLtitle());
			pstmt.setString(2, log.getLcontent());
			pstmt.setInt(3, log.getLid());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Log> queryAll() {
		try {
			String sql = "Select * from log";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Log> list = new ArrayList<>();
			while (rs.next()) {
				Log log = new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				list.add(log);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Log> queryByUid(int uid) {
		try {
			String sql = "Select * from log where uid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			List<Log> list = new ArrayList<>();
			while (rs.next()) {
				Log log = new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				list.add(log);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Log> queryWithReadNum() {
		try {
			String sql = "Select * from log order by readnum asc limit 0,10";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Log> list = new ArrayList<>();
			while (rs.next()) {
				Log log = new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				list.add(log);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Log getLogByLid(int lid) {
		try {
			String sql = "Select * from log where lid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
