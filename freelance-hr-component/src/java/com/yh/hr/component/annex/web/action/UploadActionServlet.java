package com.yh.hr.component.annex.web.action;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.hr.component.annex.facade.UploadAnnexComponentFacade;
import com.yh.hr.component.annex.utils.UploadAnnexComponentUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.SpringBeanUtil;

/**
 * 合并上传文件
 */
public class UploadActionServlet extends HttpServlet {
	UploadAnnexComponentFacade uploadAnnexComponentFacade = (UploadAnnexComponentFacade) SpringBeanUtil.getBean("uploadAnnexComponentFacade");
	private static final long serialVersionUID = 1L;
	//private String serverPath = "e:/";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入合并后台...");
		String action = request.getParameter("action");
		Date now = DateUtil.now();
		String path = UploadAnnexComponentUtil.getFilePath(now);
		if ("mergeChunks".equals(action)) {
			// 获得需要合并的目录
			String fileMd5 = request.getParameter("fileMd5");
			String fileName = request.getParameter("fileName");
			String file_id = request.getParameter("file_id");
			// 读取目录所有文件
			File f = new File(path + "/" + fileMd5);
			File[] fileArray = f.listFiles(new FileFilter() {

				// 排除目录，只要文件
				@Override
				public boolean accept(File pathname) {
					if (pathname.isDirectory()) {
						return false;
					}
					return true;
				}
			});

			// 转成集合，便于排序
			List<File> fileList = new ArrayList<File>(Arrays.asList(fileArray));
			// 从小到大排序
			Collections.sort(fileList, new Comparator<File>() {

				@Override
				public int compare(File o1, File o2) {
					if (Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName())) {
						return -1;
					}
					return 1;
				}

			});
			
			// 新建保存文件
			File outputFile = new File(path + "/" + fileName);

			// 创建文件
			outputFile.createNewFile();

			// 输出流
			FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
			FileChannel outChannel = fileOutputStream.getChannel();

			// 合并
			FileChannel inChannel;
			for (File file : fileList) {
				inChannel = new FileInputStream(file).getChannel();
				inChannel.transferTo(0, inChannel.size(), outChannel);
				inChannel.close();

				// 删除分片
				file.delete();
			}

			// 关闭流
			fileOutputStream.close();
			outChannel.close();

			// 清除文件夹
			File tempFile = new File(path + "/" + fileMd5);
			if (tempFile.isDirectory() && tempFile.exists()) {
				tempFile.delete();
			}
			//保存数据库
			FileAnnexDTO dto= new FileAnnexDTO(); 
			String fileId = request.getParameter("fileId");
			String faUserName = request.getParameter("faUserName");
			dto.setFaDate(now);
			dto.setFaName(fileName);
			dto.setFaPath(path+"/"+fileName);
			dto.setFaUserName(faUserName);
			dto.setFileId(fileId);
			try {
				String faId = uploadAnnexComponentFacade.createAnnexFile(dto);
				response.getWriter().write("{\"faId\":\""+faId+"\",\"file_id\":\""+file_id+"\"}");
				System.out.println("合并文件成功");
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("checkChunk".equals(action)) {
			// 校验文件是否已经上传并返回结果给前端

			// 文件唯一表示								
			String fileMd5 = request.getParameter("fileMd5");
			// 当前分块下标
			String chunk = request.getParameter("chunk");
			// 当前分块大小
			String chunkSize = request.getParameter("chunkSize");

			// 找到分块文件
			File checkFile = new File(path + "/" + fileMd5 + "/" + chunk);

			// 检查文件是否存在，且大小一致
			response.setContentType("text/html;charset=utf-8");
			if (checkFile.exists() && checkFile.length() == Integer.parseInt((chunkSize))) {
				response.getWriter().write("{\"ifExist\":1}");
			} else {
				response.getWriter().write("{\"ifExist\":0}");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
