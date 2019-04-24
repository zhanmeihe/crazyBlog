package com.test.main;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

public class Sor {

	public Sor() {
		// TODO Auto-generated constructor stub
	}

	private static String getHtml(String address) {
		StringBuffer html = new StringBuffer();
		String result = null;
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
//			conn.setRequestProperty(
//					"User-Agent",
//					"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
			BufferedInputStream in = new BufferedInputStream(
					conn.getInputStream());
			try {
				String inputLine;
				byte[] buf = new byte[4096];
				int bytesRead = 0;
				while (bytesRead >= 0) {
					inputLine = new String(buf, 0, bytesRead, "ISO-8859-1");
					html.append(inputLine);
					bytesRead = in.read(buf);
					inputLine = null;
				}
				buf = null;
			} finally {
				in.close();
				conn = null;
				url = null;
			}
			result = new String(html.toString().trim().getBytes("ISO-8859-1"),
					"gb2312").toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		html = null;
		return result;
	}

//	public static void main(String[] args) {
//
//		/**
//		 * INSERT INTO TBL_IBP_CATEGORY_CHANNEL_MAP
//		 * (ID,ELEMENT_ID,ACTION,PARENT_CODE
//		 * ,ID,ELEMENT_CODE,PARENT_ID,SEQUENCE,VALID_START
//		 * ,VALID_END,INSERT_TIME,ORIGINAL_TIME,LOG_ID) VALUES
//		 * (SEQ_IBP_CATEGORY_CHANNEL_MAP.NEXTVAL ,
//		 * 'ff8080814581e8a00145884958ea722c','REGIST','7777777788000009201707190
//		 * 0 0 0 0 0 0 4 ' ,
//		 * 'ff8080815d4f5fe4015d59e6ef3a01df','00000021000000022014042200000004'
//		 * , 'ff8080815d4f5fe4015d589d42b90072','9992','20140422000000',
//		 * '20440422000000',SYSDATE-350,'20170719','404841' )
//		 */
//		String rus = "INSERT INTO TBL_IBP_CATEGORY_CHANNEL_MAP(ID,ELEMENT_ID,ACTION,PARENT_CODE,ID,ELEMENT_CODE,"
//				+ "PARENT_ID,SEQUENCE,VALID_START,VALID_END,INSERT_TIME,ORIGINAL_TIME,LOG_ID) "
//				+ "VALUES(SEQ_IBP_CATEGORY_CHANNEL_MAP.NEXTVAL ,'ff8080814581e8a00145884958ea722c',"
//				+ "'REGIST','77777777880000092017071900000004','ff8080815d4f5fe4015d59e6ef3a01df',"
//				+ "'00000021000000022014042200000004','ff8080815d4f5fe4015d589d42b90072','9992','20140422000000',"
//				+ "'20440422000000',SYSDATE-350,'20170719','404841')";
//
//		String start = "INSERT INTO TBL_IBP_CATEGORY_CHANNEL_MAP "
//				+ "(ID,CHANNEL_ID,CATEGORY_ID,ELEMENT_ID,"
//				+ "ACTION,PARENT_CODE,ELEMENT_CODE,PARENT_ID,"
//				+ "SEQUENCE,VALID_START,VALID_END,INSERT_TIME,"
//				+ "ORIGINAL_TIME,LOG_ID) VALUES ";
//
//		String[] ss = rus
//				.substring(rus.indexOf("(SEQ") + 1, rus.lastIndexOf("')") + 1)
//				.replace(" ", "").split(",");
//		String[] dos = { "(" + ss[0] + ",", ss[1] + ",", ss[1] + ",",
//				ss[2] + ",", ss[3] + ",", ss[4] + ",", ss[5] + ",",
//				ss[6] + ",", ss[7] + ",", ss[8] + ",", ss[9] + ",",
//				ss[10] + ",", ss[11] + ",", ss[12] + ")" };
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < dos.length; i++) {
//			sb.append(dos[i]);
//		}
//
//		String cd = start + sb.toString();
//		System.err.println(cd);
//
//		/**
//		 * 
//						 
//		 */
//	}
	public static void main(String[] args) {
		
		System.getProperties().setProperty("proxySet", "true");  
		System.getProperties().setProperty("http.proxyHost", "113.141.122.11");
		System.getProperties().setProperty("http.proxyPort", "6513");
		System.out.println(getHtml("http://www.jb51.net/article/31589.htm")
				); //判断代理是否设置成功
	}

}
