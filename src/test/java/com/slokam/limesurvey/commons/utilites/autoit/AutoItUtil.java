package com.slokam.limesurvey.commons.utilites.autoit;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.commons.utilites.data.AutomationUtils;
import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class AutoItUtil {
	private final Logger logger = LoggerFactory.getLogger(AutoItUtil.class);
	AutoItX auto = null;
	
	public AutoItUtil() {
		// Pre-req - > Open elevated command prompt ( Run As Administrator) 
		// Goto src/test/resources/drivers folder
		// Run regsvr32 AutoItX3_x64.dll
		File file = new File("./src/test/resources/drivers/jacob-1.14.3-x64.dll");
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		auto = new AutoItX();
	}
	
	
	public void uploadFile(String filePath) {
		logger.debug("Uploading file -  " + filePath);
		auto.winWait("Open","",30);
		auto.winActivate("Open");
		AutomationUtils.sleep(4);
		auto.controlSend("Open", "", "[CLASS:Edit; INSTANCE:1]", filePath);
		auto.controlClick("Open", "", "[CLASS:Button; INSTANCE:1]");
		logger.debug("Uploaded successfully");
	}
	
	public static void main(String[] args) {
		File  file = new File("./src/test/resources/testdata/sample.jpg");
		AutoItUtil autoit = new AutoItUtil();
		autoit.uploadFile(file.getAbsolutePath().replace("\\.\\", "\\"));
	}
}