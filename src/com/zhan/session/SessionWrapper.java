package com.zhan.session;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionWrapper {

	private static Logger logger = LoggerFactory.getLogger(SessionWrapper.class);

	/**
	 * 设置值
	 * 
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		request.getSession(true).setAttribute(key, value);
	}

	/**
	 * 取值
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			return request.getSession().getAttribute(key);
		} catch (Exception e) {
			logger.info("{}", e);
			return null;
		}
	}

	/**
	 * 删除值
	 * 
	 * @param key
	 */
	public static void remove(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		request.getSession().removeAttribute(key);
	}

	/**
	 * 销毁Session
	 */
	public static void invalidate() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// request.getSession().invalidate();
		Object element = null;
		HttpSession session = request.getSession();
		@SuppressWarnings("rawtypes")
		Enumeration e = session.getAttributeNames();
		String attrName = null;
		while (e.hasMoreElements()) {
			element = e.nextElement();
			if (element instanceof String) {
				attrName = (String) element;
				try {
					session.removeAttribute(attrName);
				} catch (Exception ex) {
					logger.info("remove session attribute " + attrName + " {} ", ex);
				}
			}
		}

	}
}
