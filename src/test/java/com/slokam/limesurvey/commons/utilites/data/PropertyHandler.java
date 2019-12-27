package com.slokam.limesurvey.commons.utilites.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class PropertyHandler {
	private final Logger logger = LoggerFactory.getLogger(PropertyHandler.class);
	Properties props = null;

	public PropertyHandler(String filename) {
		File file = new File("./src/test/resources/" + filename);
		try {
			FileInputStream fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PropertyHandler(String folderName,String filename) {
		File file = new File(folderName+ filename );
		try {
			FileInputStream fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PropertyHandler() {
		File file = new File("./src/test/resources/app.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			Assert.fail("app properties file not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		String value = "";
		if (key == "" || key == null || key.equals("")) {
			Assert.fail(key + " is not availble ");
		} else {
			value = props.getProperty(key);
		}
		return value;
	}

	public String getProperty(String key, String dValue) {
		String value = "";
		value = props.getProperty(key, dValue);
		return value;
	}


}