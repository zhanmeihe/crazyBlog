package com.zhan.ex;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 错误代码与错误信息的映射。
 * 
 */
public class UnisErrMap {

	private static final Logger LOGGER = LoggerFactory.getLogger(UnisErrMap.class);

	/** 错误码与错误信息 **/
	private static Properties properties;

	/** 初始化 **/
	static {
		InputStream inputStream = null;
		try {
			properties = new Properties();
			inputStream = UnisErrMap.class.getClassLoader().getResourceAsStream("ds.errmap.properties");
			properties.load(inputStream);
		} catch (Exception ex) {
			LOGGER.error("DSErrMap初始化错误", ex);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (Exception ee) {
				LOGGER.error("DSErrMap初始化错误", ee);
			}
		}
	}

	public static String getProperty(String key, String defaultValue) {
		try {
			String result = (String) properties.get(key.trim());
			if (StringUtils.isBlank(result))
				result = defaultValue;
			return result;
		} catch (Exception ex) {
			LOGGER.error("获取属性错误", ex);
			return defaultValue;
		}
	}

	public static String getProperty(String key) {
		return getProperty(key, "");
	}

}
