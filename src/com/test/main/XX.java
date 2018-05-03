package com.test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.unis.computer.info.domain.utils.FileUtils;

public class XX {

	public XX() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException, IOException {
		
	 
//		BufferedReader reader = null;
//		reader = new BufferedReader(new InputStreamReader(
//				new FileInputStream("/home/zhan/ee/testEPG.txt"), "UTF-8"));
//		String tempString = null;
//		File fi = new File("/home/zhan/ee/");
//		File[] dd =  fi.listFiles();
//		//EpgCompare_20170910_IPTV_NN.txt
//		for (File file : dd) {
//			
//			if (file.getName().contains("EpgCompare")&&file.length()>1) {
//				String datestr =  file.getName();
//				datestr = datestr.substring(datestr.indexOf("_")+1, datestr.lastIndexOf("_IPTV"));
//				Date de = new Date();
//				SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
//				String time = sf.format(de); 
//				 if (datestr.equals(time)) {
//					System.err.println(file.getName());
//				}
//			}
//			
//		}
//		String temp[] = null;
//		while ((tempString = reader.readLine()) != null) {
//			temp = tempString.split(" ");
//			for (String string : temp) {
//				 
//					System.err.println(string);
//				 
//				 
//			}
//		}
//		
//		URLEncoder url = null;
//		String ss = url.encode(" ");
//		System.err.println(ss);
//		String sa = url.encode("2017-09-01");
//		System.err.println(sa);
//		@SuppressWarnings("deprecation")
//		String dd =  url.encode("2017-09-01 12:23:34");
//		System.err.println(dd);
//		URLDecoder wq = null;
	 
		String sql = " SELECT  T.*,  B.CATEGORY_NAME  FROM TBL_DUPLICATE_CHANNEL T,       TBL_CHANNEL_ORIGINAL_CATEGORY B  WHERE T.ORIGINAL_CATEGORY_ID = B.ORIGINAL_CATEGORY_ID(+)  AND T.ORG_TYPE = 0 ORDER BY INSERT_TIME DESC,  1 ";
	
		String sqlto = " SELECT  T.*,  B.CATEGORY_NAME  FROM TBL_DUPLICATE_CHANNEL T,       TBL_CHANNEL_ORIGINAL_CATEGORY B  WHERE T.ORIGINAL_CATEGORY_ID = B.ORIGINAL_CATEGORY_ID(+)  AND T.ORG_TYPE = 0 ORDER BY INSERT_TIME DESC,  1 ";
		
		if (sql.indexOf("INSERT_TIME DESC") !=-1) {
			sql = sql.replace("INSERT_TIME DESC", "channel_name asc");
			System.err.println(sql);
		}
		
		
		//	wq.decode(s)
//		Timestamp startTime = new Timestamp(new Date().getTime());
//		Timestamp dd = fortime("01:56:05",startTime);
//		
//		System.err.println(dd);
	}
	
	public static Timestamp fortime(String date,Timestamp startTime){
		long hh = 1L;
		long mm = 1L;
		long ss = 1L;
		long totaltime = 1L;
		 
		String[] temp = date.split(":"); 
		
		if (temp[0].indexOf("0")!=-1) {
			 
			String hh1 = temp[0];
			int  hh2 = Integer.parseInt(hh1.substring(1));
			hh =  (hh2*60)*(60*1000);
			 
		}else {
			 hh = (Integer.parseInt(temp[0])*60)*(60*1000);
			 System.err.println(hh);
		}
		if (temp[1].indexOf("0")!=-1) {
			 
			String mm1 = temp[1];
			int mm2 = Integer.parseInt(mm1.substring(1));
			mm = mm2*60*1000;
		}else {
			mm = Integer.parseInt(temp[1])*(60*100);
		}
		if (temp[2].indexOf("0")!=-1) {
			 
			String ss1 = temp[2];
			int ss2 = Integer.parseInt(ss1.substring(1));
			ss = ss2*1000;
		}else {
			ss = Integer.parseInt(temp[2])*1000;
		}
		totaltime = hh+mm+ss;
		System.err.println(totaltime);
		return new Timestamp(startTime.getTime()+totaltime);
	}
}
