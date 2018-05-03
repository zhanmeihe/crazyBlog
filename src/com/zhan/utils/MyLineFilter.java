package com.zhan.utils;

import cn.nusof.common.io.file.mapping.LineFilter;

public class MyLineFilter implements LineFilter {

	@Override
	public boolean accept(String line) {
		if (line.startsWith("#")) {
			return false;
		}
		return true;
	}

}
