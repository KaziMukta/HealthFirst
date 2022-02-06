package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigProp {
	
	private static ReadConfigProp readConfigProp;
	private static String url;
	private static int implicitWait;
	private static int pageLoadWait;
	
	private static final String configPath="C:\\Users\\Arvin\\eclipse-workspace\\HealthFirst\\src\\test\\resources\\configuration\\config.property";
	
	private ReadConfigProp() {
		
	}
	public static ReadConfigProp getInstanceProp() {
		if(readConfigProp==null) {
		   readConfigProp=new ReadConfigProp();
		   loadProp();
		}
		return readConfigProp;
	}
	private static void loadProp() {
		try {
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream(configPath);
		properties.load(fis);
		url=properties.getProperty("url");
		implicitWait=Integer.parseInt(properties.getProperty("implicitWait"));
		pageLoadWait=Integer.parseInt(properties.getProperty("pageLoadtWait"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public String getHealthFirstUrl() {
		return url;
	}
	public int getImplicitWait() {
		return implicitWait;
	}
	public int getPageLoadWait() {
		return pageLoadWait;
	}
	

}
