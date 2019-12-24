package com.slokam.limesurvey.commons.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.slokam.limesurvey.commons.utilites.data.PropertyHandler;

public class CustomRetry implements IRetryAnalyzer {
	private final Logger logger = LoggerFactory.getLogger(CustomRetry.class);
	int count;

	public CustomRetry() {
		PropertyHandler app = new PropertyHandler();
		String countProp = app.getProperty("retryCount", "0");
		count = Integer.parseInt(countProp);
	}

	public boolean retry(ITestResult result) {
		if (count == 0) {
			return false;
		} else {
			count--;
			return true;
		}
	}

}
