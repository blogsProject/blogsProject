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
				// String name = item.getFieldName();
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
						// int r = (int) (Math.random() * 1000);
						// SimpleDateFormat sd = new
						// SimpleDateFormat("hhmmssSSS");
						// start = filename.lastIndexOf("."); // ���������һ����
						// String expanded_name = filename.substring(start);
						List<String> fileNamelist = filesService.selectFileNameByUid(uid);
						filename = filenameIsExist(filename, filename, fileNamelist, 1);
						file = new File(path, filename);
					} while (file.exists());
					// д��������ȥ
					item.write(file);
					filesService.insertByFiles(new Files(0, null, dir + "/" + filename, flag ? "ͼƬ" : "����", uid));
					response.getWriter().write(filename);
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

	/**
	 * �ж��ļ��Ƿ������ݿ������ ������ھͼ��� (����) ����window��������
	 * 
	 * @param fileold
	 *            ԭ�����ļ���
	 * @param filename
	 *            ���ĺ���ļ��� ע:�������������ʱ��fileold��filenameҪһ��
	 * @param fileNamelist
	 *            ��Ҫ�жϵ��ļ��ַ�������
	 * @param count
	 *            ���ִӼ���ʼ Ĭ�ϴ�1��ʼ
	 * @return �޸ĺ���ļ�������δ�޸ĵ��ļ���(��������ļ���������)
	 */
	public static String filenameIsExist(String fileold, String filename, List<String> fileNamelist, int count) {
		if (count <= 0)
			count = 1;
		if (!fileNamelist.contains(filename))
			return filename;
		return filenameIsExist(fileold, fileold + "(" + count++ + ")", fileNamelist, count);
	}

}
