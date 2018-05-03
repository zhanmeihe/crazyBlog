package com.zhan.ex;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RuleException extends Exception {

	private static final long serialVersionUID = -5928816667490047659L;

	private String code;

	private Map<String, String> errors = new HashMap<String, String>();
   
	protected RuleException() {
	}

	public RuleException(String code) {
		super(UnisErrMap.getProperty(code, code));
		this.code = code;
	}

	public RuleException(String code, Throwable cause) {
		super(UnisErrMap.getProperty(code, code), cause);
		this.code = code;
	}

	public RuleException(String code, Object... parameters) {
		super(parseMessage(UnisErrMap.getProperty(code, code), parameters));
		this.code = code;
	}

	public RuleException(String code, String[] messages) {
		super(parseMessage(UnisErrMap.getProperty(code, code), messages));
		this.code = code;
	}

	public RuleException(Map<String, String> errors) {
		super(formatMessages(errors));
		this.errors = errors;
	}

	public String getCode() {
		return this.code;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	private static String parseMessage(String template, Object[] parameters) {
		return String.format(template, parameters);
	}

	private static String parseMessage(String template, String[] args) {
		if (template.indexOf("{}") < 0)
			return template;
		StringBuilder sb = new StringBuilder();
		String[] clips = (template + " ").split("\\{\\}");
		for (int i = 0; i < clips.length; i++) {
			sb.append(clips[i]);
			if (args != null && i < args.length && i < clips.length - 1)
				sb.append(args[i]);
		}
		return sb.substring(0, sb.length() - 1);
	}

	private static String formatMessages(Map<String, String> errors) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : errors.entrySet()) {
			sb.append(entry.getValue());
			sb.append(";");
		}
		if (sb.length() > 0) {
			return StringUtils.removeEnd(sb.toString(), ";");
		}
		return sb.toString();
	}
}
