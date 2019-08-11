package com.vtiger.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vtiger.common.Config;

public class BaseTest {
	
public WebDriver driver;
public static ExtentReports report;
public static ExtentTest logger; 
public static String extentReport;
	
	
	public void LaunchApp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/com/vtiger/utilities/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Config.url);
	}

}
