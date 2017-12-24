package com.zhangluping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhangluping.dao.ReplyDAO;
import com.zhangluping.entiy.Reply;
import com.zhangluping.util.DBConnection;

public class ReplyDAOImpl implements ReplyDAO {

	@Override
	public int insertByReply(Reply reply) {
		try {
			String sql = "insert reply(rid,lid,rcontent,rdate) value(?,?,?,now())";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getRid());
			pstmt.setInt(2, reply.getLid());
			pstmt.setString(3, reply.getRcontent());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Reply> selectByLid(int lid) {
		try {
			String sql = "Select * from reply where lid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			ResultSet rs = pstmt.executeQuery();
			List<Reply> list = new ArrayList<>();
			while (rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				list.add(reply);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
