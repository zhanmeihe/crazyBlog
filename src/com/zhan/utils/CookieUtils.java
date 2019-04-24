package com.zhan.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * cookie判断
 * @author zhanmeihe
 *
 */
public class CookieUtils {

	public CookieUtils() {
		// TODO Auto-generated constructor stub
	}

	
	public static Boolean ifCookies(HttpServletRequest request) {

		Cookie[] cookie = request.getCookies();
		if (cookie == null || cookie.length < 3) {
			return false;
		}
		for (Cookie cookies : cookie) {
			if (cookies.getName().equals("userName")) {
				if (!cookies.getValue().equals("")) {
					return true;
				}
			}
		}
		return false;
	}

}
