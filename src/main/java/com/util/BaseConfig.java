package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseConfig {

	public String getConfig(String key) throws Exception {//
		// fileInput stream = serialization (Test data ==> stream)
		// 3
		File file = new File("./Config.properties");

		// 2
		FileInputStream fs = new FileInputStream(file);

		// 1
		Properties pro = new Properties();
		pro.load(fs);
		
		String value =pro.get(key).toString();

		System.out.println(value);
		
		return value;

	}

	public static void main(String[] args) throws Exception {
		// need to call getConfig method inside
		// check static =Y/N >> No = create object or owner class
		BaseConfig obj = new BaseConfig();
		obj.getConfig("InValid_Password");
	}

}
