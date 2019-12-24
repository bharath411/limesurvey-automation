package com.slokam.limesurvey.commons.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.slokam.limesurvey.commons.pages.base.BasePage;

public class GlobalSettingsPage extends BasePage {

	public void clickLanguageTab() {
		waitForElement(By.xpath("//a[contains(text(),'Language')]")).click();
	}
	
	
	public String getDefaultLanguageValue() {
		
		WebElement selectLanguageElement = waitForElement(By.id("defaultlang"));
		Select select = new Select(selectLanguageElement);
		WebElement selectedOption = select.getFirstSelectedOption();
		String defaultLanguage = selectedOption.getText().trim();
		return defaultLanguage;
	}
	
	
	public void moveAllVisibleLanguagesToHidden() {
		WebElement selectIncludeLanguagesElement = waitForElement(By.id("includedLanguages"));
		Select select = new Select(selectIncludeLanguagesElement);
		
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			webElement.click();
		}
		waitForElement(By.id("btnRemove")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();
	}
	
	public void moveLanguageFromHiddenToVisible(String language) {
		
		WebElement selectExcludedLanguagesElement = waitForElement(By.id("excludedLanguages"));
		Select select = new Select(selectExcludedLanguagesElement);
		select.selectByVisibleText(language);
		
		waitForElement(By.id("btnAdd")).click();
	}
	
	public void clickOnSaveButton() {
		waitForElement(By.id("save-form-button")).click();
	}
	
	
	public String getSaveMessage() {
		return waitForElement(By.cssSelector(".alert")).getText();
	}
}
