package com.service.TestCollect.service;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<String> f = new ArrayList<>();
		f.add("1");
		f.add("2");
		f.add("3");
		f.add("4");
		List<Integer> s = new ArrayList<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		String r = "1";
		for (Integer integer : s) {
			System.err.println(integer);
//			for (String string : f) {
//				if (f.equals(string)) {
//					System.err.println("test");
//					continue;
//				}
//			}

			if (f.contains(r)) {
				System.err.println("y");
				break;

			}

		}
	}

}
