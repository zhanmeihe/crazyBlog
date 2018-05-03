package com.test.main;

public class Num {

	public Num() {
		// TODO Auto-generated constructor stub
	}

	// 计算汉字个数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "总共佛违法和威尔返回，搜房今晚444";
		char[] t1 = null;
		t1 = src.toCharArray();
		int t0 = t1.length;
		int count = 0;
		for (int i = 0; i < t0; i++) {
			if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
				count++;

			}
		}
		System.out.println(count);
	}

}
