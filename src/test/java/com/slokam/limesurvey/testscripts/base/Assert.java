package com.slokam.limesurvey.testscripts.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assert {

	protected static final Logger logger = LoggerFactory.getLogger(Assert.class);

	public static void assertEquals(String actual, String expected, String errorMessage) {
		try {
			logger.debug("Message -  : " + actual);
			org.testng.Assert.assertEquals(actual, expected, errorMessage);
			DriverInstance.getInstance().getExtentTest().pass("" + actual);
		} catch (AssertionError e) {
			org.testng.Assert.fail(errorMessage, e);

		}
	}

	public static void assertEquals(String actual, String expected) {
		assertEquals(actual, expected, "");
	}

	public static void assertTrue(boolean status, String errorMessage) {
		try {
			org.testng.Assert.assertTrue(status, errorMessage);
		} catch (AssertionError e) {
			org.testng.Assert.fail(errorMessage, e);
			logger.error(e.getMessage());
		}

	}

	public static void assertTrue(boolean status) {
		assertTrue(status, "");
	}
}
