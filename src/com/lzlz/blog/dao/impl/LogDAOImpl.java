package com.lzlz.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.blog.dao.LogDAO;
import com.lzlz.blog.entiy.Log;
import com.lzlz.blog.util.CustomerUtil;
import com.lzlz.blog.util.DBConnection;

public class LogDAOImpl implements LogDAO {

	@Override
	public int insertByLog(Log log) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert log(ltitle,lcontent,ltime,uid,readnum) value(?,?,now(),?,?)";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, log.getLtitle());
			pstmt.setString(2, log.getLcontent());
			pstmt.setInt(3, log.getUid());
			pstmt.setInt(4, log.getReadnum());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public int deleteByLid(int lid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from log where lid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public int updateByLog(Log log) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update log set ltitle=?,lcontent=? where lid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, log.getLtitle());
			pstmt.setString(2, log.getLcontent());
			pstmt.setInt(3, log.getLid());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public List<Log> queryAll(int curpage, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select lid,ltitle,lcontent,ltime,uid,readnum,(select username from user where user.uid=log.uid) from log order by lid desc limit ?,? ";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, CustomerUtil.limitFristParmaWithMyql(curpage, count));
			pstmt.setInt(2, count);
			ResultSet rs = pstmt.executeQuery();
			List<Log> list = new ArrayList<>();
			while (rs.next()) {
				Log log = new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				log.setUname(rs.getString(7));
				list.add(log);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return null;
	}

	@Override
	public List<Log> queryByUid(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select lid,ltitle,lcontent,ltime,uid,readnum,(select username from user where user.uid=log.uid) from log where uid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			List<Log> list = new ArrayList<>();
			while (rs.next()) {
				Log log = new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				log.setUname(rs.getString(7));
				list.add(log);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return null;
	}

	@Override
	public List<Log> queryWithReadNum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select lid,ltitle,lcontent,ltime,uid,readnum,(select username from user where user.uid=log.uid) from log order by readnum desc limit 0,10";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Log> list = new ArrayList<>();
			while (rs.next()) {
				Log log = new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				log.setUname(rs.getString(7));
				list.add(log);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return null;
	}

	@Override
	public Log getLogByLid(int lid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select lid,ltitle,lcontent,ltime,uid,readnum,(select username from user where user.uid=log.uid) from log where lid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return new Log(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6),
					rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return null;
	}

	@Override
	public int getPageByCountWhithUid(int count, int uid) {
		return CustomerUtil.getPage(count, getAllCountByUid(uid));
	}

	@Override
	public int getAllCountByUid(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select count(*) from log where uid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public int updateByLidWhithReadNum(int lid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update log set readnum=readnum+1 where lid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public int getAllCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select count(*) from log";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public int getPageWhithAll(int count) {
		return CustomerUtil.getPage(count, getAllCount());
	}
}
