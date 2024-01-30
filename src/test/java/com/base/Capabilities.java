package com.base;

import java.net.URL;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.App;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class Capabilities {
	
	public AppiumDriver driver;
	public Properties properties;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite(alwaysRun = true)
	public void setUp() {
			
		try {
		properties = new Properties();
		properties.load(App.class.getClassLoader().getResourceAsStream("./config/podcast.properties"));
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		//desiredCapabilities.setCapability("newCommandTimeout", 30000);
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,properties.getProperty("automationName"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("platformName"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("platformVersion"));
        //desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, properties.getProperty("timeout"));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("deviceName"));
		desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + properties.getProperty("appPath"));
	    desiredCapabilities.setCapability("appium:appPackage", properties.getProperty("appPackage"));
	    desiredCapabilities.setCapability("appium:appActivity", properties.getProperty("appActivity"));
	    driver = new AndroidDriver(new URL(properties.getProperty("appiumServerUrl")), desiredCapabilities);
	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void startReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/Extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("MyReport");
        sparkReporter.config().setReportName("Test Report");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	@AfterTest
    public void endReport() {
        extent.flush();
    }

	@AfterSuite
	public void tearDown() {
		driver.quit();
		System.out.println("quit....");
	}
	

}
