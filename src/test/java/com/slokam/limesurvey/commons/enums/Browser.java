package com.slokam.limesurvey.commons.enums;


public enum Browser {
	CHROME, 
	FIREFOX, 
	INTERNET_EXPLORER("InternetExplorer"), 
	ANDROID,
	IOS;

	String browser;

	Browser() {
		browser = toString();
	}

	Browser(String browser) {
		this.browser = browser;
	}

	public String getBrowser() {
		return browser;
	}

	public static Browser fromString(String browser) {
		if (browser == null) {
			return null;
		}
		for (Browser browserName : Browser.values()) {
			if (browser.equalsIgnoreCase(browserName.getBrowser())) {
				return browserName;
			}
		}
		return null;
	}
}