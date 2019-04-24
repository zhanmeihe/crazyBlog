package com.zhan.utils;

public class ChinesepreNum {

	public ChinesepreNum() {
		// TODO Auto-generated constructor stub
	}

	//识别中文字符count
	public int chineseCount(String content) {
		char[] t1 = null;
		t1 = content.toCharArray();
		int t0 = t1.length;
		int count = 0;
		for (int i = 0; i < t0; i++) {
			if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
				count++;

			}
		}
		return count;
	}

}
