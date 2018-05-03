package com.zhan.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ContextUtil {

	public static String getClientIp() {
		HttpServletRequest request = getRequest();
		if (request == null) {
			return null;
		}
		return getClientIp(request);
	}

	public static String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null) {
			ip = ip.trim();
			if (ip.length() > 31) {
				ip = ip.substring(0, 31);
			}
		}
		return ip;

	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request;
	}

	public static String getRequestPath() {
		return getRequest().getRequestURI();
	}

	public static String getRequestPathAndQueryString() {
		HttpServletRequest request = getRequest();
		return getRequestPathAndQueryString(request);
	}

	public static String getRequestPathAndQueryString(HttpServletRequest request) {
		String qs = request.getQueryString();
		String path = request.getRequestURI();
		if (!StringUtils.isEmpty(qs)) {
			path += "?" + qs;
		}
		return path;
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		String ajax = request.getParameter("ajax");
		if (StringUtils.isEmpty(ajax))
			return false;
		return Boolean.parseBoolean(ajax);
	}

	public static boolean isAjaxRequest() {
		return isAjaxRequest(getRequest());
	}

	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		if (url.indexOf("ajax=true") < 0 && isAjaxRequest(request)) {
			if (url.indexOf('?') > 0) {
				sb.append("&ajax=true");
			} else {
				sb.append("?ajax=true");
			}
		}
		response.sendRedirect(sb.toString());
	}
}
