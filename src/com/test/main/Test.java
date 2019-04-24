package com.test.main;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
 
public class Test {
	
	 
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void method3() throws Exception {  
	    URL urlfile = new URL("http://flv4.bn.netease.com/videolib3/1706/10/Ljqrz4439/SD/Ljqrz4439.flv");  
	    //File file = new File("C:\\music\\test2.mp3");  
	    //URL urlfile = file.toURI().toURL();  
	    URLConnection con = urlfile.openConnection();  
	     //con.setConnectTimeout(3*1000);
	     con.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
	    int b = con.getContentLength();
	    BufferedInputStream bis = new BufferedInputStream(con.getInputStream());  
	    Bitstream bt = new Bitstream(bis);  
	    Header h = bt.readFrame();  
	   
	    int time = (int) h.total_ms(b);  
	    System.out.println(time / 1000);  
}  
	
	public static void main(String[] args) throws Exception {
		 
		
		System.err.println((600/60));
		System.err.println((600%60));
	}

}
