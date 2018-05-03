package com.zhan.ex;

public class UnisException extends RuntimeException {

	private static final long serialVersionUID = -984761084862940925L;
	private String message;
	private String code;

	public UnisException() {
		super();
	}

	public UnisException(String message) {
		this.message = message;
		this.code = "300";
	}

	public UnisException(String message, Throwable e) {
		super(message, e);
	}

	public UnisException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
