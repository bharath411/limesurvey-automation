package com.slokam.limesurvey.commons.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.commons.pages.base.BasePage;
import com.slokam.limesurvey.commons.enums.USERS;
import com.slokam.limesurvey.testscripts.base.Assert;

public class LoginPage extends BasePage {
	private final Logger logger = LoggerFactory.getLogger(LoginPage.class);


	public boolean login(String username, String password, boolean isRemember) {
		By userNameBy = By.id("loginPage:loginForm:username");
		By passwordBy = By.id("loginPage:loginForm:password");
		By submitBtnBy = By.id("loginPage:loginForm:loginButton");
		By rememberMeBy = By.xpath("//label[@for='loginPage:loginForm:rememberMe']");

		/*By emailNotValidBy = By.id("loginPage:loginForm:username-error");
		By noticeBlockErrorBy = By.id("notice-block-error");*/
		WebElement userEle = waitForElement(userNameBy);
		userEle.clear();
		userEle.sendKeys(username);

		WebElement passwordEle = waitForElement(passwordBy);
		passwordEle.clear();
		passwordEle.sendKeys(password);

		WebElement rememberMe = waitForElement(rememberMeBy);

		if (!rememberMe.isSelected()) {
			if (isRemember) {
				logger.trace("Checking  - Remember me");
				rememberMe.click();
			}
		} else if (!isRemember) {
			logger.trace("Un Checking  - Remember me");
			rememberMe.click();
		}

		waitForElement(submitBtnBy).click();

	/*	if (!isElementPresent(emailNotValidBy, 2)) {
			logger.error("Error message - " + waitForElement(emailNotValidBy).getText());
			throw new RuntimeException(waitForElement(emailNotValidBy).getText());
		}
		if (!isElementPresent(noticeBlockErrorBy, 2)) {
			logger.error("Error message - " + waitForElement(noticeBlockErrorBy).getText());
			throw new RuntimeException(waitForElement(noticeBlockErrorBy).getText());
		}*/
		String title = driver.getTitle();
		while(title.equals("")){
			title = driver.getTitle();
			sleep(1);
		}
		
		logger.trace("Title after clicking on login button  - " + title);
		if (title.contains("Home")) {
			return true;
		} else  {
			Assert.assertTrue(false, waitForElement(By.cssSelector(".message-box p")).getText());
		} {
			return false;
		}
	}

	public boolean login(String username, String password) {
		return login(username, password, false);
	}

	public boolean login(USERS user) {
		return login(user.getUsername(), user.getPassword());
	}
}
