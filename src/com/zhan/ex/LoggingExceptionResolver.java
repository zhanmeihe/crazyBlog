package com.zhan.ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.zhan.utils.ContextUtil;

public class LoggingExceptionResolver extends SimpleMappingExceptionResolver {

	private static Logger logger = LoggerFactory.getLogger(LoggingExceptionResolver.class);

	private String ajaxErrorView;

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		ModelAndView mv = super.doResolveException(request, response, handler, ex);
		logger.debug("exception request uri: " + request.getRequestURI());
		if (!StringUtils.isEmpty(ajaxErrorView) && ContextUtil.isAjaxRequest(request)) {
			mv.setViewName(ajaxErrorView);
			logger.debug("ajax request set view name to " + ajaxErrorView);
		}
		ExceptionHandler.errorInit(ex, mv.getModelMap());
		return mv;
	}

	public void setAjaxErrorView(String ajaxErrorView) {
		this.ajaxErrorView = ajaxErrorView;
	}
}
