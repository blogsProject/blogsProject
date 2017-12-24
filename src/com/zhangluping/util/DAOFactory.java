package com.zhangluping.util;

import com.zhangluping.dao.FilesDAO;
import com.zhangluping.dao.LogDAO;
import com.zhangluping.dao.MessageDAO;
import com.zhangluping.dao.ReplyDAO;
import com.zhangluping.dao.UserDAO;
import com.zhangluping.service.FilesService;
import com.zhangluping.service.LogService;
import com.zhangluping.service.MessageService;
import com.zhangluping.service.ReplyService;
import com.zhangluping.service.UserService;

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
}
