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
		try {
			String sql = "insert friend(first,second) value(?,?)";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, friend.getFirst());
			pstmt.setLong(2, friend.getSecond());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBySecondId(int first, int second) {
		try {
			String sql = "delete from friend where second=? and first=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, second);
			pstmt.setInt(1, first);
			System.out.println(pstmt.toString());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Integer> selectByFirst(int first) {

		try {
			String sql = "Select second from friend where first=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, first);
			ResultSet rs = pstmt.executeQuery();
			List<Integer> list = new ArrayList<>();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
