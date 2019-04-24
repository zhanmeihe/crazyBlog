package com.zhan.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MaptoListUtils {

	public MaptoListUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static List  mapTransitionList(Map map) {
		List list = new ArrayList();
		Iterator iter = map.entrySet().iterator();  //获得map的Iterator
		while(iter.hasNext()) {
			Entry entry = (Entry)iter.next();
			list.add(entry.getValue());
		}
		return list;
	}

}
