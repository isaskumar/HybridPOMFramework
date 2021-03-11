package com.qa.web.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getApplicaionURL() {
		String url=prop.getProperty("baseURL");
		return url;	
	}
	
	public String getUserName() {
		String username=prop.getProperty("username");
		return username;	
	}
	
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;	
	}
}
