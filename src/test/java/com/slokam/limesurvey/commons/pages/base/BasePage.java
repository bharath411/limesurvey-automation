package com.slokam.limesurvey.commons.pages.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentTest;
import com.slokam.limesurvey.commons.utilites.data.PropertyHandler;
import com.slokam.limesurvey.commons.enums.SelectOptions;
import com.slokam.limesurvey.testscripts.base.DriverInstance;

public class BasePage {
	private final Logger logger = LoggerFactory.getLogger(BasePage.class);
	public PropertyHandler appProps;
	public int waitTime;
	public WebDriver driver;
	public WebDriverWait waitDriver = null;
	public Actions actionsDriver = null;
	public String appUrl;
	public PropertyHandler bundle;
	
	public ExtentTest extentTest = null;

	public BasePage() {
		this.driver = DriverInstance.getInstance().getDriver();
		appProps = new PropertyHandler();
		waitTime = Integer.parseInt(appProps.getProperty("waitTime", "30"));
		waitDriver = new WebDriverWait(driver, waitTime);
		actionsDriver = new Actions(driver);
		appUrl = appProps.getProperty("url");
		extentTest = DriverInstance.getInstance().getExtentTest();
		bundle = new PropertyHandler("./src/test/resources/testdata/" , "messages.properties" );
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean isElementPresent(By by) {
		return isElementPresent(by, waitTime);
	}

	public boolean isElementPresent(By by, int waitTime) {
		boolean status = true;
		setImpliciteWait(waitTime);
		if (!(driver.findElements(by).size() > 0)) {
			status = false;
		}
		setDefaultImpliciteWait();
		return status;
	}

	public void setImpliciteWait(int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void setDefaultImpliciteWait() {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public boolean isElementPresent1(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void sleep(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement waitForElement(By by) {
		WebElement element = null;
		List<WebElement> elements = driver.findElements(by);

		if (elements.size() > 0) {
			element = elements.get(0);
			// waitUntillClickable(element);
			return element;
		} else {
			logger.error(" element - " + by.toString() + " not available after waiting  " + waitTime + " seconds ");
			throw new NoSuchElementException(by.toString());
		}

	}

	public boolean waitUntillClickable(WebElement element) {
		String elementDetails = element.toString();
		try {
			element = waitDriver.until(ExpectedConditions.elementToBeClickable(element));
			if (element == null) {
				logger.trace(elementDetails + "is not clickable");
				return false;
			}

			logger.trace(element.toString() + " is available and clickable");
			return true;
		} catch (TimeoutException e) {
			logger.error("exception occured while waiting for element - " + element.toString() + " to be clickable "
					+ e.getMessage());
			return false;
		} catch (Exception e) {
			logger.error("exception occured while waiting for element - " + element.toString() + " to be clickable "
					+ e.getMessage());
			return false;
		}
	}

	public void waitForPageReady() {
		// to be implement
	}
	
	public WebElement getElementWithText(By by,String text){
		List<WebElement> elements  = driver.findElements(by);
		WebElement ele = null;
		for(WebElement element : elements){
			if(element.getText().contains(text)){
				ele = element;
				break;
			}
		}
		
		return ele;
	}
	
	public List<String> getElementsTextAreaInList(By cssSelector) {
		List<WebElement> elements = driver.findElements(cssSelector);
		List<String> textList  = new ArrayList<String>();
		for (WebElement webElement : elements) {
			textList.add(webElement.getText());
		}
		
		return textList;
	}
	
	public void selectOption(By by,String option,SelectOptions type){
		
		Select select = new Select(waitForElement(by));
		switch (type) {
		case TEXT:
			select.selectByVisibleText(option);
			break;
		case INDEX:
			int index = 0;
			try{
			 Integer.parseInt(option);
			}catch (Exception e) {
				logger.error("Please provide proper input data", e);
			}
			select.deselectByIndex(index);
			break;
		case VALUE:
			select.selectByValue(option);
			break;

		default:
			break;
		}
	}

	public void scrollDown(){
		JavascriptExecutor jdriver = (JavascriptExecutor)driver;
		jdriver.executeScript("window.scrollBy(0,500)");
	}
}
