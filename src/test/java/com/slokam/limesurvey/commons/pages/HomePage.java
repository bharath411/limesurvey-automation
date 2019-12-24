package com.slokam.limesurvey.commons.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.commons.pages.base.BasePage;
import com.slokam.limesurvey.commons.enums.Navigation;

public class HomePage extends BasePage{
	private final Logger logger = LoggerFactory.getLogger(MakeAClaimPage.class);
	
	public void waitForPageToLoad() {
		waitForPageReady();
		String headerTitle = waitForElement(By.id("headerTitle")).getText();
		logger.debug("header title - " + headerTitle);
	}
	
	public boolean verifyLeftNavigation(Navigation navigation){
		By item = By.xpath("//a[@title='"+navigation.getItem()+"']");
		return isElementPresent(item);
	}
	public void clickLeftNavigation(Navigation navigation) {
		By item = By.xpath("//a[@title='"+navigation.getItem()+"']");
		waitForElement(item).click();
	}
}
