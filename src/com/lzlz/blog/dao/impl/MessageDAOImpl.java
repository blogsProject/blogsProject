package com.lzlz.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.blog.dao.MessageDAO;
import com.lzlz.blog.entiy.Message;
import com.lzlz.blog.util.CustomerUtil;
import com.lzlz.blog.util.DBConnection;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public int insertByMessage(Message message) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert message(sendid,receiveid) value(?,?)";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getSendid());
			pstmt.setInt(2, message.getReceiveid());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public int deleteByMid(int mid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from message where mid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

	@Override
	public List<Message> selectByReceiveId(int receiveid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			String sql = "select mid,sendid,receiveid,(select username from user where user.uid=message.sendid) from message where receiveid=?";
			conn = new DBConnection().getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, receiveid);
			ResultSet rs = pstm.executeQuery();
			List<Message> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Message(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstm);
		}
		return null;
	}

	@Override
	public int getPageByReceiveId(int count, int receiveid) {
		return CustomerUtil.getPage(count, getAllCountByReceiveId(receiveid));
	}

	@Override
	public int getAllCountByReceiveId(int receiveid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			String sql = "select count(*) from message where receiveid=?";
			conn = new DBConnection().getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, receiveid);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			int ret = rs.getInt(1);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				new DBConnection().closeConnection(conn, pstm);
			}
		}
		return 0;
	}

	@Override
	public int deleteBySendOrRece(int sendid, int receiveid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from message where sendid=? and receiveid=?";
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sendid);
			pstmt.setInt(2, receiveid);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new DBConnection().closeConnection(conn, pstmt);
		}
		return 0;
	}

}
