package com.test.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listcom {

	public static <T> List<T> compare(T[] t1, T[] t2) {
		List<T> list1 = Arrays.asList(t1);
		List<T> list2 = new ArrayList<T>();
		for (T t : t2) {
			if (!list1.contains(t)) {
				list2.add(t);
			}
		}
		return list2;
	}

	public static void main(String[] arg) {
		 
		//地市select x.dst_code from tbl_terminal_unit x where x.org_id = 6
		String[] array1 = { "1", "2", "3","5" };
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("dff1");
		lists.add("dff2");
		lists.add("dff3");
		lists.add("dff4");
		lists.add("dff5");
		String[] array = new String[lists.size()];
		String f  ="sdlksf ";
		String r = "$$$";
		 
		String[] s=lists.toArray(array);
		//System.out.println(Arrays.toString(s));
		//中心
		//中心 > 地市（4,44）
		//地市 > 中心（5）
		String[] array2 = { "1", "2", "3", "4", "44" };
		List<String> list = compare(array1, array2);
		for (String integer : list) {
			System.out.println(integer);
		}
	}

}
