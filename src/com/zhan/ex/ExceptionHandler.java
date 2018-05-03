package com.zhan.ex;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.zhan.utils.CommonUtils;
import com.zhan.utils.ContextUtil;
 

public class ExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	public static final void errorInit(Exception e, ModelMap modelMap) {
		errorInit(e, modelMap, "");
	}

	public static final void errorInit(Exception e, ModelMap modelMap, String errorCode) {
		String path = ContextUtil.getRequestPathAndQueryString();
		String errorId = CommonUtils.getErrorId();
		String errorMsg = e.getMessage();
		String errorType;
		String logMsg;
		if (e instanceof UnisException) {
			errorType = "RuleException";
			logMsg = String.format("规则验证错误: errorId=%1$s; path=%2$s; error=%3$s", errorId, path, errorMsg);
			logger.info(logMsg);
		} else if (e instanceof RuntimeException) {
			errorType = "";
			logMsg = String.format("服务器产生异常: errorId=%1$s; path=%2$s; error=%3$s; {}", errorId, path, errorMsg);
			logger.error(logMsg, e);
		} else {
			errorType = "";
			logMsg = String.format("服务器处理发生异常: errorId=%1$s; path=%2$s; error=%3$s; {}", errorId, path, errorMsg);
			logger.info(logMsg, e);
		}
		fillModelMap(modelMap, errorMsg, errorType, errorId, errorCode);
	}

	public static final void errorInit(String msg, ModelMap modelMap, String errorCode) {
		String path = ContextUtil.getRequestPathAndQueryString();
		String errorId = CommonUtils.getErrorId();
		String logMsg = String.format("服务器产生异常: errorId=%1$s; path=%2$s; code=%3$s; error=%4$s", errorId, path,
				errorCode, msg);
		logger.info(logMsg);
		fillModelMap(modelMap, msg, "", errorId, errorCode);
	}

	private static final void fillModelMap(ModelMap modelMap, String msg, String errorType, String errorId,
			String errorCode) {
		modelMap.put("error", true);
		String errorMsg = StringUtils.isEmpty(msg) ? "" : msg.replaceAll("'", "\"");
		modelMap.put("errorMsg", errorMsg);
		modelMap.put("errorType", errorType);
		modelMap.put("errorId", errorId);
		modelMap.put("errorCode", errorCode);
	}
}
