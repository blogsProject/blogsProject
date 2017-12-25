package com.lzlz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.dao.MessageDAO;
import com.lzlz.entiy.Message;
import com.lzlz.util.CustomerUtil;
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

	@Override
	public List<Message> selectByReceive(int receive, int curpage, int count) {
		try {
			String sql = "select * from message where receive=? limit ?,?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, receive);
			pstm.setInt(2, CustomerUtil.limitFristParmaWithMyql(curpage, count));
			pstm.setInt(3, count);
			ResultSet rs = pstm.executeQuery();
			List<Message> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
			if (conn != null)
				conn.close();
			if (pstm != null)
				pstm.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getPageByReceive(int count, int receive) {
		return CustomerUtil.getPage(count,
				CustomerUtil.getAllCount(new DBConnection().getConnection(), "message", "receive=?", count));
	}

}
