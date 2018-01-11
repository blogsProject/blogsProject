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
	 * �ļ��ϴ�
	 * 
	 * @param request
	 *            HttpServletRequest ʵ������
	 * @param response
	 *            HttpServletResponse ʵ������
	 * @param filesService
	 *            FilesService ʵ������
	 * @param flag
	 *            �ļ����� true ͼƬ false ����
	 * @param uid
	 *            �û�id
	 */

	public static void uploadProcess(HttpServletRequest request, HttpServletResponse response,
			FilesService filesService, int uid) {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// ��ȡ�ϴ��ļ���ŵ� Ŀ¼ , ���򴴽�
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String path = request.getRealPath("/upload/" + uid);
		System.out.println(new File(path).mkdirs());
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		diskFileItemFactory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		diskFileItemFactory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		try {
			// ���ϴ�����ļ�
			@SuppressWarnings("unchecked")
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ �ύ���� ������
				// String name = item.getFieldName();
				// �ַ����� ����
				if (item.isFormField()) {
					String value = item.getString();
				}
				// ��������
				else {
					// ��ȡ�ϴ��ļ�������
					String filename = item.getName();
					// ��ȡ�ļ���(��������չ��)
					String filename_no_externn = filename.substring(0, filename.lastIndexOf("."));
					// ��ȡ(+1��ȥ����б��)
					File file = null;
					String expanded_name = filename.substring(filename.lastIndexOf(".") + 1);
					do {
						// �����ļ���
						// int r = (int) (Math.random() * 1000);
						// SimpleDateFormat sd = new
						// SimpleDateFormat("hhmmssSSS");
						// start = filename.lastIndexOf("."); // ���������һ����
						List<String> fileNamelist = filesService.selectFileNameByUid(uid);
						filename = CustomerUtil.filenameIsExist(filename_no_externn, filename_no_externn, expanded_name,
								fileNamelist, 1);
						file = new File(path, filename);
					} while (file.exists());
					// д��������ȥ
					int type = CustomerUtil.isImageOrMusic(expanded_name);
					if (type == 3) {
						request.setAttribute("ret", 6);
						request.getRequestDispatcher("resultProcess.jsp").forward(request, response);
						return;
					}
					filesService.insertByFiles(new Files(0, null, uid + "/" + filename, type == 1 ? "ͼƬ" : "����", uid));
					item.write(file);
					response.sendRedirect("File.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ļ� ͨ���ļ�·��
	 * 
	 * @param request
	 *            servlet��HttpServletRequest ʵ������
	 * @param response
	 *            HttpServletResponse ʵ������
	 * @throws IOException
	 */
	public static void downloadProcess(HttpServletRequest request, HttpServletResponse response, Files file)
			throws IOException {
		String filename = request.getRealPath("upload") + "/" + file.getFpath();
		File f = new File(filename);
		if (!f.exists()) {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("�ļ�������");
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
