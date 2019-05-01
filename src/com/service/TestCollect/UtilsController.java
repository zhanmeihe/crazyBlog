package com.service.TestCollect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.TestCollect.dao.BlogInfoDao;
import com.service.TestCollect.pojo.BlogInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhan.ex.UnisException;
import com.zhan.response.CommonResponse;
import com.zhan.response.SuccessResponse;
import com.zhan.utils.CommonUtils;
import com.zhan.utils.Const;
import com.zhan.utils.FtpUtil;

@Controller
public class UtilsController {

	@Resource
	private BlogInfoDao blogInfoDao;

	@ResponseBody
	@RequestMapping(value = "/updateData", method = RequestMethod.GET, produces = "application/json")
	public String updateBlogData(BlogInfo blogInfo) {

		try {
			//List<BlogInfo> bloglist = new ArrayList<>();
			BlogInfo info = new BlogInfo();
			//bloglist = blogInfoDao.selectallData("1ca384f062c940e494ff8c75fcb3ac4d",0);
			int c = 0;
			//for (BlogInfo blogInfo : bloglist) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
				String FileName = sdf.format(new Date());
				String localPath = Const.UPLOADFILE_PATH + FileName + "/" + blogInfo.getBlogId() + ".txt";
				write(localPath, blogInfo.getBlogContent(), "utf-8");
				FileInputStream in = new FileInputStream(new File(localPath));
				FtpUtil.uploadFile(FtpUtil.ftpHost, FtpUtil.ftpUserName, FtpUtil.ftpPassword, FtpUtil.ftpPort,
						FileName + "/", blogInfo.getBlogId() + ".txt", in);
				info.setBlogContent(FtpUtil.ftpPath + FileName + "/" + blogInfo.getBlogId() + ".txt");
				//info.setUpdateDate(CommonUtils.getNowDate());
				//info.setBlogId(blogInfo.getBlogId());
				//blogInfoDao.updateUserInfo(info);
//				++c;
//				if (c == 2000) {
//					c = 0;
//					deleteDir(new File(Const.UPLOADFILE_PATH));
//				}

			//}
			return info.getBlogContent();
		} catch (UnisException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;

	}

	public static void write(String path, String content, String encoding) throws IOException {

		File file = new File(path);

		if (!new File(path.substring(0, path.lastIndexOf("/") + 1)).exists()) {

			new File(path.substring(0, path.lastIndexOf("/") + 1)).mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), encoding));
		writer.write(content);
		writer.close();
	}

//	public static void main(String[] args) throws IOException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
//		String FileName = sdf.format(new Date());
//		write("/home/blogfile/uplaod/file/" + FileName + "/ww.txt", "123", "utf-8");
//		// deleteDir(new File(Const.UPLOADFILE_PATH));
//	}

	public static boolean deleteDir(File dir) {
		if (!dir.exists())
			return false;
		if (dir.isDirectory()) {
			String[] childrens = dir.list();
			// 递归删除目录中的子目录下
			for (String child : childrens) {
				boolean success = deleteDir(new File(dir, child));
				if (!success)
					return false;
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	public static void main(String[] args) {
		 
		System.err.println(20/10);
	}

}
