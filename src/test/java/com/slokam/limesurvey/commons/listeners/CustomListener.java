package com.slokam.limesurvey.commons.listeners;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.slokam.limesurvey.commons.utilites.data.AutomationUtils;
import com.slokam.limesurvey.commons.utilites.reports.Screenshot;
import com.slokam.limesurvey.testscripts.base.DriverInstance;

public class CustomListener implements ITestListener {
	private final Logger logger = LoggerFactory.getLogger(CustomListener.class);
	public void onTestStart(ITestResult result) {
		System.out.println("Test execution started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed");
		WebDriver driver = DriverInstance.getInstance().getDriver();
		ExtentTest extentTest = DriverInstance.getInstance().getExtentTest();
		System.out.println("test failed");
		String timestamp = AutomationUtils.getCurrentDate();
		String fileName = result.getMethod().getMethodName() +"_"+ timestamp+ ".jpg";

		String fullPath = new Screenshot(driver).captureScreenshot(fileName);
		System.out.println(fullPath);
		try {
			extentTest.addScreenCaptureFromPath("./"+fileName);
			extentTest.pass(result.getMethod().getMethodName() + " is scuccessfully completed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = DriverInstance.getInstance().getDriver();
		ExtentTest extentTest = DriverInstance.getInstance().getExtentTest();
		System.out.println("test failed");
		String timestamp = AutomationUtils.getCurrentDate();
		String fileName = result.getMethod().getMethodName() +"_"+ timestamp+ ".jpg";

		String fullPath = new Screenshot(driver).captureScreenshot(fileName);
		System.out.println(fullPath);
		try {
			extentTest.addScreenCaptureFromPath("./"+fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(result.getThrowable().getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {
		ExtentTest extentTest = DriverInstance.getInstance().getExtentTest();
		System.out.println("test skipped");
		if(extentTest!=null)
			DriverInstance.removeTest(extentTest);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("On start of test cases");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution completed");

		Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();

		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			String failClassName = method.getRealClass().getName();
			try {
				for (ITestResult iTestResult : skippedTests) {
					String skipClassName = iTestResult.getMethod().getRealClass().getName();
					if ((skipClassName + iTestResult.getMethod().getMethodName())
							.equals(failClassName + method.getMethodName())) {
						skippedTests.remove(iTestResult);
					}
				}
			} catch (Exception e) {
			}
		}

		for (ITestResult temp : skippedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getSkippedTests().getResults(method).size() > 1) {
				skippedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					skippedTests.remove(temp);
				}
			}
		}
	}

}
