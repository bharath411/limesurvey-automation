package com.slokam.limesurvey.commons.utilites.data;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.testscripts.base.TestBase;

public class AutomationUtils {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final String REPORTS = "./reports";
	public static final String LATEST_REPORTS = REPORTS + "/latest/";
	private final Logger logger = LoggerFactory.getLogger(AutomationUtils.class);
	
	private static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());
		return time;
	}

	public static String getCurrentDate() {
		return getCurrentDateTime().substring(0, 11);
	}

	public static void deleteAndCreateLatestReportsFolder() {
		File destDir = new File(LATEST_REPORTS);
		if (destDir.exists()) {
			try {
				FileUtils.deleteDirectory(destDir.getAbsoluteFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		destDir.mkdir();
	}

	public static void createBackupFolder() {
		File destDir = new File(REPORTS + "/" + getCurrentDateTime());
		if (!destDir.exists()) {
			destDir.mkdir();
		}

		File sourceDir = new File(LATEST_REPORTS);
		
		
		try {
			File[] directoryListing = sourceDir.listFiles();
			if (directoryListing != null) {
				for (File file : directoryListing) {
					FileUtils.copyFile(file, new File(destDir+"/"+file.getName()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		String st = AutomationUtils.randomAlphaNumeric(5);
		System.out.println(st);
	}
}
