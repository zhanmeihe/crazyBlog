package com.zhan.ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zhan.utils.ContextUtil;

 

public class ViewRenderExceptionHandlerInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(ViewRenderExceptionHandlerInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (ex != null) {
			String path = ContextUtil.getRequestPathAndQueryString(request);
			logger.error("服务器生成视图错误:" + path, ex);
		}
	}
}
