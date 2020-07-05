package com.crm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

	public static final int IMPLICIT_WAIT = 20;
	public static final int PAGE_LOAD_TIMEOUT = 20;
	
	
	
	//setup for property file
	
	public static Object getProp(String key) throws IOException{
		FileInputStream file = new FileInputStream("./Config/Config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.get(key);
	}
	
	
}
