package com.slokam.limesurvey.commons.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.commons.pages.base.BasePage;

public class DashboardPage extends BasePage{

	private final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
	
	public void clickConfiguration() {
		waitForElement(By.xpath("//span[@class='icon-settings']")).click();
	}
	
	public void clickOnGlobalSettings() {
		waitForElement(By.xpath("//a[contains(text(),'Global settings')]")).click();
	}
	
	
	public void logout() {
		waitForElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[@class='dropdown'][2]//span[@class='icon-user']")).click();
		waitForElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[@class='dropdown open']//a[contains(text(),'Logout')]")).click();
	}

	public void clickManageAdministrators() {
		waitForElement(By.xpath("//a[contains(text(),'Manage survey administrators')]")).click();
	}
}
