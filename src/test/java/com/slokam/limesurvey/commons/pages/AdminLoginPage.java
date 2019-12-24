package com.slokam.limesurvey.commons.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.commons.pages.base.BasePage;

public class AdminLoginPage extends BasePage{

	private final Logger logger = LoggerFactory.getLogger(AdminLoginPage.class);
	
	
	public void login(String username,String password) {
		
		waitForElement(By.id("user")).sendKeys(username);
		waitForElement(By.id("password")).sendKeys(password);
		sleep(5);
		waitForElement(By.xpath("//button[@value='login']")).click();
	}
	
	public List<String> getLanguagesAvailableInDropdown() {
		sleep(4);
		waitForElement(By.id("select2-loginlang-container")).click();
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='select2-results']/ul/li"));
		List<String> languages = new ArrayList<String>();
		for (WebElement webElement : list) {
			languages.add(webElement.getText());
		}
		return languages;
	}
}
