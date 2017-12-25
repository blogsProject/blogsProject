package com.lzlz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lzlz.dao.MessageDAO;
import com.lzlz.entiy.Message;
import com.lzlz.util.DBConnection;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public int insertByMessage(Message message) {
		try {
			String sql = "insert message(sendid,receiveid) value(?,?)";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getSendid());
			pstmt.setInt(2, message.getReceiveid());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteByMid(int mid) {
		try {
			String sql = "delete from message where mid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
