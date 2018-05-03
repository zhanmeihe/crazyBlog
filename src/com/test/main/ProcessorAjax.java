package com.test.main;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

 

 
 

public class ProcessorAjax {

	public ProcessorAjax() {
		// TODO Auto-generated constructor stub
	}

 
	public static void ajax() {
		String url = "http://xinjinqiao.tprtc.com/admin/main/flrpro.do";
		try {
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
			// 设置webClient的相关参数
			webClient.getOptions().setJavaScriptEnabled(true);
			webClient.getOptions().setCssEnabled(false);
			webClient
					.setAjaxController(new NicelyResynchronizingAjaxController());
			// webClient.getOptions().setTimeout(50000);
			webClient.getOptions().setThrowExceptionOnScriptError(false);
			// 模拟浏览器打开一个目标网址
			HtmlPage rootPage = webClient.getPage(url);
			System.out.println("为了获取js执行的数据 线程开始沉睡等待");
			Thread.sleep(3000);// 主要是这个线程的等待 因为js加载也是需要时间的
			System.out.println("线程结束沉睡");
			String html = rootPage.asText();
			System.out.println(html);
			//AjaxController cc
//			 WebClient webClient = new WebClient(BrowserVersion.CHROME);  
//	            //webClient.setCssErrorHandler(new SilentCssErrorHandler());  
//	            webClient.setAjaxController(new NicelyResynchronizingAjaxController());  
//	            webClient.getOptions().setCssEnabled(true);  
//	            webClient.getOptions().setRedirectEnabled(false);  
//	            webClient.getOptions().setAppletEnabled(false);  
//	            webClient.getOptions().setJavaScriptEnabled(true);  
//	            webClient.getOptions().setPopupBlockerEnabled(true);  
//	            webClient.getOptions().setTimeout(10000);  
//	            HtmlPage page = webClient.getPage("http://huaban.com/favorite/home/");  
//	            System.out.println(page.asXml());  
//	            webClient.closeAllWindows();  
		} catch (Exception e) {
		}

	}
	
	public static void main(String[] args) {
		ajax();
	}

}
