package file;

import java.awt.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class AngularJSProcessor1 implements PageProcessor {

	// 爬虫的配置, 重试时间 抓取间隔

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	// 计数器
	private static boolean cc = false; 
	
	private static int count = 0;

	@Override
	public Site getSite() {

		return site;

	}

	@Override
	public void process(Page page) {
		//http://news.hebei.com.cn/system/2018/03/27/018693910.shtml
	 
		 
		if ((page.getUrl().get().equals("http://news.hebei.com.cn/rsbd/"))) {
			cc = true;
			// 加入满足条件的链接

			page.addTargetRequests(

			page.getHtml()
					.xpath("//div[@class='list']/li/a/@href")
					.all()

			);

		} else {

			// 获取页面需要的内容
			
			System.out.println("抓取的内容:"
					+ page.getHtml()
							.xpath("//div[@class='g_width content']/h1/text()")
							.get());

			count++;

		}

	}

	public static void main(String[] args) {

		long startTime, endTime;

		System.out.println("开始爬取...");

		startTime = System.currentTimeMillis();

		Spider.create(new AngularJSProcessor1())
				.addUrl("http://news.hebei.com.cn/rsbd/")
				.thread(5).run();

		endTime = System.currentTimeMillis();

		System.out.println("爬取结束,耗时约" + ((endTime - startTime) / 1000)
				+ "秒,爬取了" + count + "条记录");

	}
}
