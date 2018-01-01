package com.lzlz.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.blog.dao.UserDAO;
import com.lzlz.blog.entiy.User;
import com.lzlz.blog.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	@Override
	public int insertByUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert user(username,password,netname,relname,gender,about) value(?,?,?,?,?,?)";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getNetname());
			pstmt.setString(4, user.getRelname());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getAbout());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select * from user where username=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public int updateByUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update user set password=?,netname=?,relname=?,gender=?,about=? where uid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getNetname());
			pstmt.setString(3, user.getRelname());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getAbout());
			pstmt.setInt(6, user.getUid());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> queryAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select * from user";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUid(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select * from user where uid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<User> queryByList(List<Integer> listid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "Select * from user";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				int uid = rs.getInt(1);
				if (listid.contains(uid)) {
					User user = new User(uid, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7));
					list.add(user);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
