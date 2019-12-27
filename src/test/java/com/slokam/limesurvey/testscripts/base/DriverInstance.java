package com.slokam.limesurvey.testscripts.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.slokam.limesurvey.commons.utilites.data.PropertyHandler;
import com.slokam.limesurvey.commons.enums.Browser;

public class DriverInstance {
	private final Logger logger = LoggerFactory.getLogger(DriverInstance.class);
	private WebDriver driver;
	private PropertyHandler appProps = new PropertyHandler();
	private String chromeDriverPath;
	private String internetExplorerPath;
	private String geckoDriverPath;
	private static Map<Long, DriverInstance> iMap = Collections.synchronizedMap(new HashMap<Long, DriverInstance>());
	protected Browser browser;

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath = "./reports/latest/extentreport.html";
	private ExtentTest extentTest;
	
	public DriverInstance() {
		setDriverPath();
		initDriver();
	}

	public static DriverInstance getInstance() {
		return getInstance(false);
	}

	public static DriverInstance getInstance(boolean flag) {
		DriverInstance driverInstnace;
		long threadId = Thread.currentThread().getId();
		if (flag || iMap.get(threadId) == null) {
			driverInstnace = new DriverInstance();
			iMap.put(threadId, driverInstnace);
		}
		return iMap.get(threadId);
	}

	private void setDriverPath() {
		String osName = System.getProperty("os.name").toLowerCase().contains("win") ? "win" : "linux";
		String driverPath = "./src/test/resources/drivers/";
		System.out.println("os name is " + System.getProperty("os.name").toLowerCase());
		if (osName.equalsIgnoreCase("win")) {
			chromeDriverPath = driverPath + "/" + osName + "/chromedriver.exe";
			geckoDriverPath = driverPath + "/" + osName + "/geckodriver.exe";
			internetExplorerPath = driverPath + "/" + osName + "/IEDriverServer.exe";
		} else {
			chromeDriverPath = driverPath + "/" + osName + "/chromedriver";
			geckoDriverPath = driverPath + "/" + osName + "/geckodriver";
		}
	}

	private boolean getGridValue() {
		String gridString = appProps.getProperty("grid", "false");
		boolean grid = true;
		try {
			if (gridString.equals("false")) {
				grid = false;
			} else {
				return Boolean.valueOf(gridString);
			}
		} catch (Exception e) {
			grid = false;
		}
		return grid;
	}

	private void initDriver() {
		browser = Browser.fromString(appProps.getProperty("browser"));
		boolean grid = getGridValue();
		
			if (grid == true) {
				driver = getGridDriver(browser);
			} else {
				driver = getLocalDriver(browser);
			}
			
	}

	

	private WebDriver getGridDriver(Browser browser) {
		String hub = appProps.getProperty("gridUrl");
		DesiredCapabilities capability;

		switch (browser) {

		case FIREFOX:
			capability = DesiredCapabilities.firefox();
			FirefoxProfile profile = new FirefoxProfile();
			// Wait for 50 seconds to avoid Firefox Unresponsive warning
			profile.setPreference("dom.max_script_run_time", 50);
			profile.setPreference("dom.max_chrome_script_run_time", 50);
			capability.setCapability(FirefoxDriver.PROFILE, profile);
			break;
		case CHROME:
			capability = DesiredCapabilities.chrome();
			break;
		case INTERNET_EXPLORER:
			capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			break;
		default:
			capability = DesiredCapabilities.chrome();
		}

		try {
			driver = new RemoteWebDriver(new URL(hub), capability);
			driver.manage().window().maximize();

		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

		return driver;
	}

	private WebDriver getLocalDriver(Browser browser) {
		DesiredCapabilities capabilities;

		switch (browser) {
		case FIREFOX:
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setPreference("security.enable_java", true);
			profile.setPreference("plugin.state.java", 2);
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case INTERNET_EXPLORER:
			System.setProperty("webdriver.ie.driver", internetExplorerPath);
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			InternetExplorerOptions options = new InternetExplorerOptions(capabilities);
			driver = new InternetExplorerDriver(options);
			driver.manage().window().maximize();
			break;

		default:
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			chromeOptions.addArguments("start-maximized");
			driver = new ChromeDriver(chromeOptions);
		}

		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public static void createExtentReports() {
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
	}

	private static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig("./src/test/resources/extent-config.xml");
		return htmlReporter;
	}

	public static ExtentTest createTest(String name, String description) {
		ExtentTest extentTest = extent.createTest(name, description);
		return extentTest;
	}
	
	public void setExtentTest(ExtentTest extentTest) {
		this.extentTest = extentTest;
	}
	
	public ExtentTest getExtentTest() {
		return extentTest;
	}
	
	public static void flushReports() {
		extent.flush();
	}
	public static void removeTest(ExtentTest extentTest) {
		extent.removeTest(extentTest);
	}
}