package com.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

	public static final int IMPLICIT_WAIT = 20;
	public static final int PAGE_LOAD_TIMEOUT = 20;
	private static final String propertyFilePath= "./Config/Config.properties";
	private static Properties prop;
	
	
	//setup for property file
	
	public static Object getProp(String key) throws IOException{
		try {
			FileInputStream file = new FileInputStream(propertyFilePath);
			prop = new Properties();
			prop.load(file);
			return prop.get(key);
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
			 throw new RuntimeException("Config.properties not found at " + propertyFilePath);
		}
	}
	
}
