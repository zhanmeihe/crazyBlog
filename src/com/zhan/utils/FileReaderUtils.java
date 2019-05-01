package com.zhan.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileReaderUtils {

	public static String readFile(String filePath) throws IOException {

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String content = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
			while ((content = reader.readLine()) != null) {
				//System.err.println("test:" + content.length());
				buffer.append(content);
			}
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (NullPointerException e) {
			System.out.println(e.toString());
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		System.err.println("获取到博客文章内容，其长度为：" + buffer.length());
		return buffer.toString();

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

	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	public static void main(String[] args) throws IOException {
		 String d = "1_";
		 String result = d.substring(0, d.indexOf("_"));
		 System.err.println(result);
	}

}
