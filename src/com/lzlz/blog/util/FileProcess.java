package com.lzlz.blog.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lzlz.blog.entiy.Files;
import com.lzlz.blog.service.FilesService;

public class FileProcess {
	/**
	 * 文件上传
	 * 
	 * @param request
	 *            HttpServletRequest 实例对象
	 * @param response
	 *            HttpServletResponse 实例对象
	 * @param filesService
	 *            FilesService 实例对象
	 * @param flag
	 *            文件类型 true 图片 false 音乐
	 * @param uid
	 *            用户id
	 */

	public static void uploadProcess(HttpServletRequest request, HttpServletResponse response,
			FilesService filesService, int uid) {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 获取上传文件存放的 目录 , 无则创建
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String path = request.getRealPath("/upload/" + uid);
		System.out.println(new File(path).mkdirs());
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		diskFileItemFactory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		diskFileItemFactory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		try {
			// 可上传多个文件
			@SuppressWarnings("unchecked")
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				// 获取 提交表单的 属性名
				// String name = item.getFieldName();
				// 字符串类 属性
				if (item.isFormField()) {
					String value = item.getString();
				}
				// 二进制类
				else {
					// 获取上传文件的名字
					String filename = item.getName();
					// 获取文件名(不包含扩展名)
					String filename_no_externn = filename.substring(0, filename.lastIndexOf("."));
					// 截取(+1是去掉反斜杠)
					File file = null;
					String expanded_name = filename.substring(filename.lastIndexOf(".") + 1);
					do {
						// 生成文件名
						// int r = (int) (Math.random() * 1000);
						// SimpleDateFormat sd = new
						// SimpleDateFormat("hhmmssSSS");
						// start = filename.lastIndexOf("."); // 索引到最后一个点
						List<String> fileNamelist = filesService.selectFileNameByUid(uid);
						filename = CustomerUtil.filenameIsExist(filename_no_externn, filename_no_externn, expanded_name,
								fileNamelist, 1);
						file = new File(path, filename);
					} while (file.exists());
					// 写到磁盘上去
					int type = CustomerUtil.isImageOrMusic(expanded_name);
					if (type == 3) {
						request.setAttribute("ret", 6);
						request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
						return;
					}
					filesService.insertByFiles(new Files(0, null, uid + "/" + filename, type == 1 ? "图片" : "音乐", uid));
					item.write(file);
					response.sendRedirect("File.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载文件 通过文件路径
	 * 
	 * @param request
	 *            servlet的HttpServletRequest 实例对象
	 * @param response
	 *            HttpServletResponse 实例对象
	 * @throws IOException
	 */
	public static void downloadProcess(HttpServletRequest request, HttpServletResponse response, Files file)
			throws IOException {
		String filename = request.getRealPath("upload") + "/" + file.getFpath();
		File f = new File(filename);
		if (!f.exists()) {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("文件不存在");
			return;
		}
		response.setHeader("content-disposition",
				"attachment;filename=" + new SimpleDateFormat("YYYYMMddhhmmssSS").format(new Date()) + "."
						+ filename.substring(filename.lastIndexOf(".")));
		FileInputStream fis = new FileInputStream(f);
		OutputStream outs = response.getOutputStream();
		byte[] buff = new byte[1024 * 1024 * 50];
		int len = 0;
		while ((len = fis.read(buff)) != -1) {
			outs.write(buff, 0, len);
		}
		fis.close();
		outs.close();
	}

	public static boolean remove(HttpServletRequest request, String fpath) {
		File f = new File(request.getRealPath("upload") + "/" + fpath);
		if (f.exists())
			return f.delete();
		return false;
	}
}
