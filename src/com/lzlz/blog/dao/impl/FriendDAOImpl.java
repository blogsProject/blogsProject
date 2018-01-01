package com.lzlz.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.blog.dao.FriendDAO;
import com.lzlz.blog.entiy.Friend;
import com.lzlz.blog.util.DBConnection;

public class FriendDAOImpl implements FriendDAO {

	@Override
	public int insertByFriend(Friend friend) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert friend(first,second) value(?,?)";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, friend.getFirst());
			pstmt.setLong(2, friend.getSecond());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public int deleteBySecondId(int first, int second) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from friend where second=? and first=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, second);
			pstmt.setInt(2, first);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public List<Integer> selectByFirst(int first) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select second from friend where first=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, first);
			ResultSet rs = pstmt.executeQuery();
			List<Integer> list = new ArrayList<>();

			while (rs.next()) {
				list.add(rs.getInt(1));
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
	public boolean friendIsHave(int firstid, int secondid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select second from friend where first=? and second=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstid);
			pstmt.setInt(2, secondid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return false;
	}

}
