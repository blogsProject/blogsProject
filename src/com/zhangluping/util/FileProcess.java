package com.zhangluping.util;

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

import com.zhangluping.entiy.Files;
import com.zhangluping.service.FilesService;

public class FileProcess {
	public static void uploadProcess(HttpServletRequest request, HttpServletResponse response,
			FilesService filesService, boolean flag, int uid) {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// ��ȡ�ϴ��ļ���ŵ� Ŀ¼ , ���򴴽�
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String dir = sdf.format(date);

		String path = request.getRealPath("/upload/" + dir);
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
				String name = item.getFieldName();
				// �ַ����� ����
				if (item.isFormField()) {
					String value = item.getString();
				}
				// ��������
				else {
					// ��ȡ�ϴ��ļ�������
					String value = item.getName();
					// 1,��ȡ·��
					int start = value.lastIndexOf("\\");
					// 2,���������һ����б��
					String filename = value.substring(start + 1);// 3,
																// ��ȡ(+1��ȥ����б��)
					File file = null;
					do {
						// �����ļ���
						int r = (int) (Math.random() * 1000);
						SimpleDateFormat sd = new SimpleDateFormat("hhmmssSSS");
						start = filename.lastIndexOf("."); // ���������һ����
						String expanded_name = filename.substring(start);
						filename = sd.format(new Date()) // ʱ�������
								+ r // 1~1000�����
								+ expanded_name; // ��չ��
						file = new File(path, filename);
					} while (file.exists());
					// д��������ȥ
					item.write(file);
					filesService.insertByFiles(new Files(0, dir + "/" + filename, flag ? "ͼƬ" : "����", uid));
					response.getWriter().write(filename);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void downloadProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String filename = request.getRealPath("upload") + "/" + request.getParameter("filename");
		System.out.println(filename);
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
}
