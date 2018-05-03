package com.test.main;

import java.util.List;

import com.zhan.utils.PropertiesFactory;

public class DDSS {

	public DDSS() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		StringBuilder gg = new StringBuilder();
		List<String> lines = PropertiesFactory.loadAllWebs();
		for (String line : lines) {
			List<String> portals = PropertiesFactory.loadPortalsByWeb(line);
			for (String portal : portals) {
				 gg.append("'").append(portal).append("'").append(",");
			}
		}
		System.out.println(gg.toString());
	}

}
