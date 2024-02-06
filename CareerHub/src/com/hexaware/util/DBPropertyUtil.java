package com.hexaware.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	static String url;
	static String user;
	static String password;

	public static void getConnection() {
		String path = "C:/Users/User/eclipse-workspace/CareerHub/src/com/hexaware/util/db.properties";
		Properties properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(path);
			properties.load(input);

			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");

		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}



}