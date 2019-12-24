package com.slokam.limesurvey.testscripts.base;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.slokam.limesurvey.commons.listeners.CustomListener;
import com.slokam.limesurvey.commons.listeners.CustomRetry;
import com.slokam.limesurvey.commons.pojo.GNPMData;
import com.slokam.limesurvey.commons.utilites.data.AutomationUtils;
import com.slokam.limesurvey.commons.utilites.data.PropertyHandler;
import com.slokam.limesurvey.commons.utilites.data.excel.XlsxReader;
import com.slokam.limesurvey.commons.enums.Browser;
import com.slokam.limesurvey.commons.enums.USERS;

@Listeners(CustomListener.class)
public class TestBase {
	private final Logger logger = LoggerFactory.getLogger(TestBase.class);
	protected PropertyHandler appProps = null;
	protected WebDriver driver = null;
	protected Actions actions = null;
	protected String adminUrl = "";
	protected String appUrl = "";
	protected String username = "";
	protected String password = "";
	public static ExtentReports extent;
	public static ExtentTest test;
	public ExtentTest extentTest ;
	public int waitTime;
	
	
	
	@BeforeSuite
	public void beforeSuite(ITestContext context) {
		DriverInstance.createExtentReports();
		logger.trace("extent reports initilized");
		AutomationUtils.deleteAndCreateLatestReportsFolder();
		
		ITestNGMethod[]  methods = context.getAllTestMethods();
		for (ITestNGMethod iTestNGMethod : methods) {
			iTestNGMethod.setRetryAnalyzer(new CustomRetry());
		}
	}
	
	@AfterSuite
	public void afterSuite() {
		
		boolean reportsBackup = Boolean.parseBoolean(appProps.getProperty("reportsBackup","true"));
		if(reportsBackup)
			AutomationUtils.createBackupFolder();
		
		DriverInstance.flushReports();
	}
	
	
	@BeforeMethod
	public void launchBrowser(ITestContext context,Method method) {
		appProps = new PropertyHandler();
		appUrl = appProps.getProperty("url");
		username = appProps.getProperty("username");
		password = appProps.getProperty("password");
		waitTime = Integer.parseInt(appProps.getProperty("waitTime", "30"));
		String methodName = method.getName();
		Test[] test = method.getAnnotationsByType(Test.class);
		String description = test[0].description();
		DriverInstance driverInstance = DriverInstance.getInstance(true);

		driver = driverInstance.getDriver();
		extentTest = DriverInstance.createTest(methodName, description);
		driverInstance.setExtentTest(extentTest);
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		extentTest.log(Status.INFO, "application launched");
	}

	@AfterMethod
	public void tearDown() {
		boolean closeBrowserOnExit = Boolean.parseBoolean(appProps.getProperty("closeBrowserOnExit","true"));
		if(closeBrowserOnExit) 
			driver.quit();
	}
	
	
	public void launchAdminApp() {
		driver.get(appUrl + "/admin");
	}
	
	public GNPMData getGNPM(String testcaseName){
		XlsxReader reader = new XlsxReader();
		List<GNPMData> gnpms = null;
		// Read
		try {
			gnpms = reader.read(GNPMData.class, new File("./src/test/resources/testdata/TestData.xlsx"),
					"GNPM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GNPMData gnpmFinal = null;
		
		for (GNPMData gnpmData : gnpms) {
			System.out.println(gnpmData);
			if(gnpmData.getExecution().toLowerCase().equals("yes") && gnpmData.getTestCaseName().toLowerCase().equalsIgnoreCase(testcaseName)){
				gnpmFinal = gnpmData;
				break;
			}
		}

		if(gnpmFinal == null){
			throw new RuntimeException("Testcase not available in excel - " + testcaseName);
		}
		return gnpmFinal;
	}
	
	public USERS processUser(String name){
		USERS user = USERS.fromString(name);
		if(user == null){
			throw new RuntimeException("User not available in Enum USERS - " + name);
		}
		return user;
	}
}
