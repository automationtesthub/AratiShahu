package com.vtiger.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vtiger.common.CommonFunctions;
import com.vtiger.common.Config;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	@BeforeClass
	public void LaunchApplication()
	{
		if(report==null)
		{
			report=CommonFunctions.setupResult();
		}
		if(driver==null)
		{
		LaunchApp();	
		}
	}
	
	@Test
	public void VerifyAppUrl_TC01() throws Exception
	{
		logger=report.startTest("VerifyAppUrl_TC01");
		LoginPage lp = new LoginPage(driver);
		boolean val=lp.verifyTitle("vtiger CRM - Commercial Open Source CRM123");
		if(val)
		{
		logger.log(LogStatus.PASS, "Title Matched");
		}
		else
		{
         String filename=CommonFunctions.getscreenshot(driver);			
		logger.log(LogStatus.FAIL, "Title did not Match <span class='test-status label pass'><a href="+filename+">Screenshot</a></span>");
		}
		report.endTest(logger);
		report.flush();
		Assert.assertEquals(val, true);
	}
	
	@Test
	public void VerifyLogo_TC02()
	{
		logger=report.startTest("VerifyLogo_TC02");
		LoginPage lp = new LoginPage(driver);
		boolean val=lp.verifylogo();
		if(val)
		{
		logger.log(LogStatus.PASS, "Logo verified");
		}
		else
		{
		logger.log(LogStatus.FAIL, "Logo not found");
		}
		report.endTest(logger);
		report.flush();
		Assert.assertEquals(val, true);
	}
	
	@Test
	public void VerifyInvalidLogin_TC03()
	{
		logger=report.startTest("VerifyInvalidLogin_TC03");
		LoginPage lp = new LoginPage(driver);
		boolean val=lp.InvalidLogin("sfafaf", "asfaf");
		if(val)
		{
		logger.log(LogStatus.PASS, "invalid login success");
		}
		else
		{
		logger.log(LogStatus.FAIL, "invalid login failed");
		}
		report.endTest(logger);
		report.flush();
		Assert.assertEquals(val, true);
	}
	
	@Test
	public void VerifyvalidLogin_TC04()
	{
		logger=report.startTest("VerifyvalidLogin_TC04");
		LoginPage lp = new LoginPage(driver);
		HomePage hp=lp.validLogin(Config.userid, Config.pwd);
		boolean val=hp.verifyLogout();
		if(val)
		{
		logger.log(LogStatus.PASS, "valid login success");
		}
		else
		{
		logger.log(LogStatus.FAIL, "valid login failed");
		}
		report.endTest(logger);
		report.flush();
		Assert.assertEquals(val, true);
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}

}
