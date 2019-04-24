package com.zhan.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import cn.nusof.common.io.util.FileUtils;
import cn.nusof.core.config.support.PlaceholderPropertiesLoader;
import cn.nusof.core.io.Resource;
import cn.nusof.core.io.support.ClasspathResource;

public class PropertiesFactory {

	private static Properties commonProperties;

	public static Properties getSqlPro() {
		if (commonProperties == null) {
			PlaceholderPropertiesLoader loader = new PlaceholderPropertiesLoader();
			List<Resource> resources = new ArrayList<Resource>();
			resources.add(new ClasspathResource("application.sql.properties"));
			commonProperties = loader.getProperties(resources);
		}
		return commonProperties;
	}

	public static Properties getProperties(String web) {
		PlaceholderPropertiesLoader loader = new PlaceholderPropertiesLoader();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(new ClasspathResource(web + "/config.properties"));
		resources.add(new ClasspathResource(web + "/regex.properties"));
		return loader.getProperties(resources);
	}

	public static List<String> loadAllWebs() {
		File file = new ClasspathResource("application.config.properties").getFile();
		List<String> lines = FileUtils.readLines(file, new MyLineFilter());
		return lines;
	}

	public static List<String> loadPortalsByWeb(String web) {

		File file = new ClasspathResource(web + "/portals.txt").getFile();
		List<String> lines = new ArrayList<String>();
		if (file.exists()) {
			lines = FileUtils.readLines(file, "utf-8", new MyLineFilter());
		}
		return lines;
	}
}
