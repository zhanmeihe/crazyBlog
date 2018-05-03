package com.zhan.utils;

public class Ignore {

	public Ignore() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 大小写转换并比较
	 * @author zhanmeihe
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean ignoreCaseEquals(String Acapital, String lowercase) {
		return Acapital == null ? lowercase == null : Acapital.equalsIgnoreCase(lowercase);
	}
	

}
