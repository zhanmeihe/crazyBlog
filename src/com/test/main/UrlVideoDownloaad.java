package com.test.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * downvideo utils
 * @author zhanmeihe
 *
 */
public class UrlVideoDownloaad {

	public UrlVideoDownloaad() {
		// TODO Auto-generated constructor stub
	}
	
	  public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{  
	        URL url = new URL(urlStr);    
	        long start  = System.currentTimeMillis();
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
	                //设置超时间为3秒  
	        conn.setConnectTimeout(3*1000);  
		// 防止屏蔽程序抓取而返回403错误  
	        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
	  
	     
	        InputStream inputStream = conn.getInputStream();    
	         
	        byte[] getData = readInputStream(inputStream);      
	   
	        File saveDir = new File(savePath);  
	        if(!saveDir.exists()){  
	            saveDir.mkdir();  
	        }  
	        File file = new File(saveDir+File.separator+fileName);      
	        FileOutputStream fos = new FileOutputStream(file);       
	        fos.write(getData);   
	        if(fos!=null){  
	            fos.close();    
	        }  
	        if(inputStream!=null){  
	            inputStream.close();  
	        }  
	  
	  
	        long end = System.currentTimeMillis();
	        System.out.println("info:"+url+" download success"+"耗时为："+(end-start));   
	  
	    }  
	  
	  
	  
	    /** 
	     * 从输入流中获取字节数组 
	     * @param inputStream 
	     * @return 
	     * @throws IOException 
	     */  
	    public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
	        byte[] buffer = new byte[1024];    
	        int len = 0;    
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
	        while((len = inputStream.read(buffer)) != -1) {    
	            bos.write(buffer, 0, len);    
	        }    
	        bos.close();    
	        return bos.toByteArray();    
	    }    
	  
	    public static void main(String[] args) {  
	        try{  
	            downLoadFromUrl("http://video.dispatch.tc.qq.com/31229180/e0023lbdqvy.mp4?vkey=A3BDED0867472E77CBE10AC312984C7E0ECB54D102AE67B4CC027C1CD6A4B690802088939436060CB170076C62610F17F82D3F234E33816A42C4C35323BC5FC0C8EC2B16845485EE43A6863E1EF39EEB37D39FF7DA4895791D0D1DEC595A7E0C34FD1ECCAFF64CE7A2B06C8BD0159B72",
						"cQHEY4460.flv", "/home/zhan/");  
	        }catch (Exception e) {  
	            // TODO: handle exception  
	        }  
	    }

}
