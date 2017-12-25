package com.lzlz.blog.util;

import com.lzlz.blog.dao.FilesDAO;
import com.lzlz.blog.dao.FriendDAO;
import com.lzlz.blog.dao.LogDAO;
import com.lzlz.blog.dao.MessageDAO;
import com.lzlz.blog.dao.ReplyDAO;
import com.lzlz.blog.dao.UserDAO;
import com.lzlz.blog.service.FilesService;
import com.lzlz.blog.service.FriendService;
import com.lzlz.blog.service.LogService;
import com.lzlz.blog.service.MessageService;
import com.lzlz.blog.service.ReplyService;
import com.lzlz.blog.service.UserService;

public class DAOFactory {
	public static UserDAO getUserDAO() {
		try {
			UserDAO userDao = (UserDAO) Class.forName("com.zhangluping.dao.impl.UserDAOImpl").newInstance();
			return userDao;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static UserService getUserService() {
		try {
			UserService userService = (UserService) Class.forName("com.zhangluping.service.impl.UserServiceImpl")
					.newInstance();
			return userService;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static LogDAO getLogDAO() {
		try {
			LogDAO logDAO = (LogDAO) Class.forName("com.zhangluping.dao.impl.LogDAOImpl").newInstance();
			return logDAO;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static LogService getLogService() {
		try {
			LogService logService = (LogService) Class.forName("com.zhangluping.service.impl.LogServiceImpl")
					.newInstance();
			return logService;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ReplyDAO getReplyDAO() {
		try {
			ReplyDAO replyDAO = (ReplyDAO) Class.forName("com.zhangluping.dao.impl.ReplyDAOImpl").newInstance();
			return replyDAO;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ReplyService getReplyService() {
		try {
			ReplyService replyService = (ReplyService) Class.forName("com.zhangluping.service.impl.ReplyServiceImpl")
					.newInstance();
			return replyService;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static MessageDAO getMessageDAO() {
		try {
			MessageDAO messageDAO = (MessageDAO) Class.forName("com.zhangluping.dao.impl.MessageDAOImpl").newInstance();
			return messageDAO;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static MessageService getMessageService() {
		try {
			MessageService messageService = (MessageService) Class
					.forName("com.zhangluping.service.impl.MessageServiceImpl").newInstance();
			return messageService;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static FilesDAO getFilesDAO() {
		try {
			FilesDAO filesDAO = (FilesDAO) Class.forName("com.zhangluping.dao.impl.FilesDAOImpl").newInstance();
			return filesDAO;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static FilesService getFilesService() {
		try {
			FilesService filesService = (FilesService) Class.forName("com.zhangluping.service.impl.FilesServiceImpl")
					.newInstance();
			return filesService;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static FriendDAO getFriendDAO() {
		try {
			FriendDAO friendDAO = (FriendDAO) Class.forName("com.zhangluping.dao.impl.FriendDAOImpl").newInstance();
			return friendDAO;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static FriendService getFriendService() {
		try {
			FriendService friendService = (FriendService) Class
					.forName("com.zhangluping.service.impl.FriendServiceImpl").newInstance();
			return friendService;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
