package com.lzlz.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzlz.blog.dao.ReplyDAO;
import com.lzlz.blog.entiy.Reply;
import com.lzlz.blog.util.CustomerUtil;
import com.lzlz.blog.util.DBConnection;

public class ReplyDAOImpl implements ReplyDAO {

	@Override
	public int insertByReply(Reply reply) {
		try {
			String sql = "insert reply(uid,lid,rcontent,rdatetime) value(?,?,?,now())";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getUid());
			pstmt.setInt(2, reply.getLid());
			pstmt.setString(3, reply.getRcontent());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Reply> selectByLid(int lid, int curpage, int count) {
		try {
			String sql = "select uid,lid,rcontent,rdatetime,(select username from user where user.uid=reply.uid) from reply where lid=? limit ?,?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			pstmt.setInt(2, CustomerUtil.limitFristParmaWithMyql(curpage, count));
			pstmt.setInt(3, count);
			ResultSet rs = pstmt.executeQuery();
			List<Reply> list = new ArrayList<>();
			while (rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				reply.setUsername(rs.getString(5));
				list.add(reply);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getPageByLid(int count, int lid) {
		return CustomerUtil.getPage(count, getAllCountByLid(lid));
	}

	@Override
	public int getAllCountByLid(int lid) {
		try {
			String sql = "Select count(*) from reply where lid=?";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
