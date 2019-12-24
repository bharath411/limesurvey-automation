package com.slokam.limesurvey.commons.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.slokam.limesurvey.commons.pages.base.BasePage;

public class AdminUserControlPage extends BasePage{

	
	public void addAdminUser(String username,String email,String fullname) {
		sleep(2);
		waitForElement(By.id("add_user_admin")).click();
		waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_user")));
		waitForElement(By.id("new_user")).sendKeys(username);
		waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_email")));
		waitForElement(By.id("new_email")).sendKeys(email);
		waitForElement(By.id("new_full_name")).sendKeys(fullname);
		waitForElement(By.id("add_user_btn")).click();
	}
	
	public String getResultMessage() {
		return waitForElement(By.xpath("//div[@class='jumbotron message-box']//p")).getText();
	}
	
	public void searchUser(String username) {
		waitForElement(By.id("User_searched_value")).sendKeys(username);
		waitForElement(By.cssSelector(".btn-success")).click();
	}
	
	public void deleteSearchedUser() {
		waitForElement(By.xpath("//div[@id='all_users']//span[contains(@class,'text-danger')]")).click();
		waitForElement(By.cssSelector(".btn-ok")).click();
	}
	
	public void deleteUser(String username) {
		waitForElement(By.xpath("//td[text()='"+username+"'][1]/preceding-sibling::td[2]//span[contains(@class,'text-danger')]")).click();
		waitForElement(By.cssSelector(".btn-ok")).click();
	}
}
