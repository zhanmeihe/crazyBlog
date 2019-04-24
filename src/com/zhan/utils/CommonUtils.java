package com.zhan.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.framework.BeanFactory;
import com.app.framework.CurrentTimeProvider;
import com.zhan.ex.RuleException;

public class CommonUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CommonUtils.class);
	private static final String ERROR_ID_FORMAT = "%1$tH%1$tM%1$tS%2$s%1$tm%1$td";
	private static String localAddress;
	private static String localhostCode;
	private static CurrentTimeProvider currentTimeProvider;
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	private CommonUtils() {
	};

	static {
		try {
			localAddress = InetAddress.getLocalHost().getHostAddress();
			localhostCode = localAddress.substring(localAddress
					.lastIndexOf('.') + 1);

			initCurrentTimeProvider();
		} catch (UnknownHostException e) {
			LOGGER.debug("{}", e);
		}
	}

 
	/**
	 * 初始化时间提供者
	 */
	private  static void initCurrentTimeProvider() {
		if (BeanFactory.isReady()) {
			CurrentTimeProvider timeBean = BeanFactory
					.getBean("currentTimeProvider");
			if (timeBean != null) {
				try {
					timeBean.getCurrentTime();
					currentTimeProvider = timeBean;
					LOGGER.info("{}{}", "使用配置的时间提供器", timeBean.getClass()
							.getName());
				} catch (Exception e) {
					LOGGER.error("{}", "时间提供器无法获取时间，将使用默认提供器", e);
					currentTimeProvider = new CurrentTimeProvider();
				}
			} else {
				LOGGER.error("{}", "未找到时间提供器，将使用默认提供器");
				currentTimeProvider = new CurrentTimeProvider();
			}
		} else {
			LOGGER.info("{}", "未配置时间提供器，将使用默认提供器");
			currentTimeProvider = new CurrentTimeProvider();
		}
	}

	public static synchronized String getUUID() {
		return StringUtils.remove(UUID.randomUUID().toString(), "-");
	}

	public static String filterChinese(String chin) {
		return chin.replaceAll(
				"秀播|xiubo|官方|毒品|吸毒|黄色|赌博|色情|运营|公众号|蚁聊|助手|yiliao", "*");
	}

	// 隨機生成8位ID
	@SuppressWarnings("unused")
	private static final int LENGTH = 9;

	public static String generateNumber() {
		String no = "";
		int num[] = new int[7];
		int c = 1;
		for (int i = 1; i < 7; i++) {
			num[i] = new Random().nextInt(9);
			c = num[i];
			for (int j = 1; j < i; j++) {
				if (num[j] == c) {
					i--;
					break;
				}
			}
		}
		if (num.length > 0) {
			for (int i = 1; i < num.length; i++) {
				no += num[i];
			}
		}
		return no;
	}

	public static String isFilter(List<String> list, String inputWords) {
		changePattern(list);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String patStr = (String) it.next();
			Pattern pattern = Pattern.compile(patStr);
			Matcher matcher = pattern.matcher(inputWords);
			if (matcher.find()) {

				return patStr.replaceAll("\\\\s\\*", "");
			}
		}
		return null;
	}

	public static void changePattern(List<String> list) {
		if (null != list && list.size() > 0) {
			int index = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				String str = (String) it.next();
				int length = str.length();
				String temp = "";
				for (int i = 0; i < length; i++) {
					if (i == 0) {
						temp += str.charAt(i);
						continue;
					}
					temp = temp + "\\s*" + str.charAt(i);
				}
				list.set(index, temp);
				index++;
			}
		}
	}

	public static void main(String[] args) throws RuleException {

		// System.out.println(new Date().getTime()/1000L);

		//System.out.println(getCurrentTime());
System.err.println(getNowDate());
		// for (int i = 0; i <= 2600; i++) {
		// // System.out.println(CommonUtils.getUUID());
		//
		// }

	}

	/**
	 * 获取当前的时间信息。（包括日期和时间）
	 */
	public static Date getCurrentDate() {
		return currentTimeProvider.getCurrentTime();
	}

	public static String getCurrentTimeString() {
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		int day = date.get(Calendar.DAY_OF_MONTH);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
		int second = date.get(Calendar.SECOND);

		String time = year + "-" + (month + 1) + "-" + day + " " + hour + ":"
				+ minute + ":" + second;

		return time;
	}

	/**
	 * 获取当前的时间信息。（包括日期和时间）
	 */
	public static long getCurrentTime() {
		return currentTimeProvider.getCurrentTime().getTime();
	}

	public static Date getYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	public static int parseAgeFromIdCard(String no) {
		try {
			Calendar birthday = Calendar.getInstance();
			birthday.setTime(getBirthday(no));
			Calendar current = Calendar.getInstance();
			current.setTime(getCurrentDate());
			int age = current.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
			birthday.add(Calendar.YEAR, age);
			if (current.before(birthday)) {
				return age - 1;
			}
			if (age == 0) {
				return 1;
			}
			return age;
		} catch (Exception e) {
			return 0;
		}
	}

	public static String getErrorId() {
		Date d = CommonUtils.getCurrentDate();
		return String.format(ERROR_ID_FORMAT, d, localhostCode);
	}

	public static Date getBirthday(String idCardNo) {
		if (idCardNo.length() == 18) {
			return parseShortDate(idCardNo.substring(6, 14));
		}
		if (idCardNo.length() == 15) {
			return parseShortDate("19".concat(idCardNo.substring(6, 12)));
		}
		return getCurrentDate();
	}

	public static long getPages(int requestCount, Integer pageSize) {
		double pages = Double.valueOf(requestCount) / Double.valueOf(pageSize);
		return Math.round(pages + 0.4);
	}

	public static Date parseDate(String date) {
		return parseDate(date, Const.DATE_FORMAT);
	}

	public static Date parseShortDate(String date) {
		return parseDate(date, Const.SHORTDATE_FORMAT);
	}

	public static Date parseShortDateMonth(String date) {
		return parseDate(date, Const.SHORTDATE_MONTH_FORMAT);
	}

	public static Date parseTime(String date) {
		return parseDate(date, Const.TIME_FORMAT);
	}

	public static Date parseDate(String date, String format)
			throws IllegalArgumentException {
		if (date == null)
			return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static synchronized String getTenSerialNo() {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSSS");
			return sdf.format(date);
		} catch (Exception e) {
		}
		return null;
	}

//	public static String filerChin2(UserPersonalInfoVo vo) throws RuleException {
//		String str = "公众号|蚁聊|助手|yiliao|秀播|傻逼|官方|xiubo|运营|肾脏|肝源|肝脏|买卖|肾源|援交|有偿卖|有偿献|有偿售|援交妹|爆破证挂靠|爆破工程师挂靠|爆破安全作业工程师挂靠|爆破工程技术人员挂靠|手机短信广告机|短信收发器|短信发送器|区域短信覆盖|智能车载短信设备|区域短信广告机|车载短信|区域短信发射机|区域短信|广告机|圈地短信发送器|圈地短信|小区短信设备|小区短信广告机|圈地短信设备|小区免费定位群发设备|小区短信|出售火机吹|快排吹配件|自制快排吹视频|简易快排吹|快排吹教程|求购火机吹|快排吹图纸|出售减震吹|渔夫吹图纸|火吹的制作方法|制作吹尘狗|自制渔夫吹|自制灭火吹|diy吹尘|自制吹尘的方法|高瑜失踪|浦志强 寻衅滋事|五三六四研讨会|浦志强第一看守所|5月3日六四研讨会|浦志强|一场XX研讨会|浦和胡 无人接听|郝和刘 电话显示已经关机|浦志强和郝建 抄了家|高瑜中央机密情报|七十岁老太太卖国|高瑜神秘失踪|高瑜|秘密逮捕|高瑜镜报|高瑜失踪450天|高瑜 新闻自由奖|寻找失踪老记者|高瑜关于当前意识形态领域|高瑜nine号文件|高瑜seven不讲|高瑜九号文件|高瑜七不讲|高瑜国安局|六四纪念研讨会|浦志强失联";
//		List<String> list = new ArrayList<String>();
//		list.add(str);
//
//		String filterStr = isFilter2(list, vo.getNickName());
//		if (filterStr != null) {
//			throw new RuleException("修改信息失败");
//		}
//		return vo.getNickName();
//	}

	public static String isFilter2(List<String> list, String inputWords) {
		changePattern(list);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String patStr = (String) it.next();
			Pattern pattern = Pattern.compile(patStr);
			Matcher matcher = pattern.matcher(inputWords);
			if (matcher.find()) {
				return patStr.replaceAll("\\\\s\\*", "");
			}
		}
		return null;
	}

	public static void changePattern2(List<String> list) {
		if ((list != null) && (list.size() > 0)) {
			int index = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				String str = (String) it.next();
				int length = str.length();

				String temp = "";
				for (int i = 0; i < length; i++) {
					if (i == 0) {
						temp = temp + str.charAt(i);
					} else
						temp = temp + "\\s*" + str.charAt(i);
				}
				list.set(index, temp);
				index++;
			}
		}
		
		
	}
	
	public static String getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return (df.format(new Date()));// new Date()为获取当前系统时间
	}
}
