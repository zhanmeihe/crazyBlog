package com.zhan.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import cn.nusof.common.io.util.IOUtils;

public class Tools {

	public static String source(String input, String charset) {
		String source = "";
		// 生成一个URL对象
		try {
			URL url = new URL(input);
			// 打开URL
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.connect();
			// 得到输入流，即获得了网页的内容
			System.err.println("URL地址:########" + input);
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), charset));
			String line;
			// 读取输入流的数据，并显示
			while ((line = reader.readLine()) != null) {
				source = source + line + "\n";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return source;

	}

	public static String sources(String input, String charset) {
		String source = "";
		// 生成一个URL对象
		try {
			URL url = new URL(input);
			// 打开URL
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

//			urlConnection.setRequestProperty("Content-Length", "" + 
//			           Integer.toString(urlParameters.getBytes().length));
			urlConnection.setRequestProperty("Content-Language", "en-US");

			urlConnection.setUseCaches(false);
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
			// wr.writeBytes (urlParameters);
			wr.flush();
			wr.close();
			// 得到输入流，即获得了网页的内容
			System.err.println("URL地址:########" + input);
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), charset));
			String line;
			// 读取输入流的数据，并显示
			while ((line = reader.readLine()) != null) {
				source = source + line + "\n";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return source;

	}

	public static String sut(String inS, String charset) throws IOException {
		HttpURLConnection connection = null;
		try {
			System.setProperty("http.keepAlive", "false");
			URL url = new URL(inS);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			// connection.disconnect();
			connection.setRequestProperty("Connection", "close");
			connection.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
			connection.setRequestProperty("Content-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,nb;q=0.6,ja;q=0.5");
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Mobile Safari/537.36");
			connection.setRequestProperty("Host", "www.fstv.com.cn");
			connection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			connection.setRequestProperty("Cookie",
					"PHPSESSID=e1saf1luf10j4kbgg3hbsqlrs2; pgv_pvi=2367410176; pgv_si=s1716564992; Hm_lvt_a85285f9718c6ca87b07d2d671617464=1521362006; Hm_lpvt_a85285f9718c6ca87b07d2d671617464=1521362041");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(5000);
			System.err.println("请求code等于：" + connection.getResponseCode());
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(connection.getInputStream()));
			DataInputStream input = new DataInputStream(connection.getInputStream());
			String ret = "";
			// String ret = "";
			if (input != null) {
				for (int c = input.read(); c != -1; c = input.read()) { // InterfaceHelper.java:695
					ret = ret + String.valueOf((char) c);
				}
			}

//		       while ((inputLine = in.readLine()) != null) 
//		       {
//		            ret = ret + inputLine;
//		       }
			// if(in!=null)
			// in.close();
			if (connection != null)
				connection.disconnect();
			if (ret != null && ret.length() > 0) {
				return ret;
			}

		} catch (Exception e) {
			System.err.println(connection.getResponseCode());
			e.printStackTrace();

		}
		return null;
	}

	public static String get(String url) throws IOException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		URLConnection conn = null;
		byte[] buf = new byte[4096];

		try {
			URL a = new URL(url);
			conn = a.openConnection();
			InputStream is = conn.getInputStream();
			int ret = 0;
			while ((ret = is.read(buf)) > 0) {
				os.write(buf, 0, ret);
			}
			// close the inputstream
			is.close();
			return new String(os.toByteArray());
		} catch (IOException e) {
			try {
				int respCode = ((HttpURLConnection) conn).getResponseCode();
				InputStream es = ((HttpURLConnection) conn).getErrorStream();
				int ret = 0;
				// read the response body
				while ((ret = es.read(buf)) > 0) {
					os.write(buf, 0, ret);
				}
				// close the errorstream
				es.close();
				return "Error response " + respCode + ": " + new String(os.toByteArray());
			} catch (IOException ex) {
				throw ex;
			}
		}
	}

	public static String getPageSource(String pageUrl, String pageEncode) {
		StringBuffer sb = new StringBuffer();
		try {
			// 构建一URL对象
			URL url = new URL(pageUrl);
			// 使用openStream得到一输入流并由此构造一个BufferedReader对象
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), pageEncode));
			String line;
			// 读取www资源
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		System.err.println(source("https://blog.csdn.net/wangpeng047/article/details/12101913", "utf-8"));
//		public String getPageSource()
//		  {
//		    StringBuffer sb = new StringBuffer();
//		    try {
//		      //构建一URL对象
//		      URL url = new URL(pageUrl);
//		      //使用openStream得到一输入流并由此构造一个BufferedReader对象
//		      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), pageEncode));
//		      String line;
//		      //读取www资源
//		      while ((line = in.readLine()) != null)
//		      {
//		        sb.append(line);
//		      }
//		      in.close();
//		    }
//		    catch (Exception ex)
//		    {
//		      System.err.println(ex);
//		    }
//		    return sb.toString();
	}
	// System.err.println(sut("https://www.fstv.com.cn/news/page/1", "utf-8"));
//		  try {
//	            //创建一个URL实例
//	            URL url = new URL("https://www.fstv.com.cn/news/page/1");
//
//	            try {
//	                //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
//	                InputStream is = url.openStream();
//	                InputStreamReader isr = new InputStreamReader(is,"utf-8");
//
//	                //为字符输入流添加缓冲
//	                BufferedReader br = new BufferedReader(isr);
//	                String data = br.readLine();//读取数据
//
//	                while (data!=null){//循环读取数据
//	                    System.out.println(data);//输出数据
//	                    data = br.readLine();
//	                }
//	                br.close();
//	                isr.close();
//	                is.close();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        } catch (MalformedURLException e) {
//	            e.printStackTrace();
//	        }
//	    
	// }//

	public static String getSource(String input, String charset) {
		String source = "";
		try {
			URL url = new URL(input);
			URLConnection connection = url.openConnection();

			connection.connect();
			InputStream stream = connection.getInputStream();
			source = IOUtils.toString(stream, charset);
		} catch (Exception e) {
			return source;
		}
		return source;
	}

	public static String getGzipSource(String input, String charset) {
		String source = "";
		try {
			URL url = new URL(input);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,nb;q=0.6,ja;q=0.5");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Cookie",
					"uuid_tt_dd=10_37208317730-1541092207669-552428; smidV2=20181102151327fb690d1eb224b217736392fd6a11d3cb004c9ca6c73732f20; _ga=GA1.2.1657390146.1541412400; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; ADHOC_MEMBERSHIP_CLIENT_ID1.0=be435443-d132-2020-164e-28b8f0c8107b; UM_distinctid=1670cd84e1290f-0d99c193f740b5-35677407-13c680-1670cd84e132dc; dc_session_id=10_1542530679470.716368; ARK_ID=JS4ddfef9dede576587c5f69d9ab5521164ddf; UserName=qq_28567955; UserInfo=RAKcvTaZbT0Hgexz82jgVudy52Tynz9vFj3FxDQqegLqWerGVqG%2Fdcz1AWP6sX5c2Vg4JkzEaA358vRk0VONWw1njQNu%2B1lxXA1rI4qq%2B6H1gi%2Fpp8gBrwPPCY7CJG21oS8PpEwdc3zE9hlq%2FsFQhA%3D%3D; UserToken=48c6f9e696c04581ac9fe8cfdf5d0024; UserNick=qq_28567955; AU=915; UN=qq_28567955; BT=1543392050654; TY_SESSION_ID=ff2cb899-5e17-48fc-82ac-78b8c89156be; tipShow=true; __yadk_uid=UDlVaK2OHFfhTaqBXWQUjFl64X0ySt7d; dc_tos=piytiq; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1543509967,1543510216,1543512044,1543512051; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1543512051");
			conn.setRequestProperty("Host", "www.csdn.net");

			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Mobile Safari/537.36");
			InputStream stream = conn.getInputStream();
			source = IOUtils.toString(stream, charset);

			if (source.equals("") || source == null) {
				System.err.println("获取目标地址数据失败，等待两秒重试N遍");
				Thread.sleep(2500);
				getGzipSource(input, charset);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return source;
	}
}
