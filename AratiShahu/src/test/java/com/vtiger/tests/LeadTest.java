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
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

public class LeadTest extends BaseTest {
	



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
	public void VerifyLeadMadatory_TC06()
	{
		logger=report.startTest("VerifyLeadMadatory_TC06");
		LoginPage lp = new LoginPage(driver);
		HomePage hp=lp.validLogin(Config.userid, Config.pwd);
		hp.clickNewLead();
		LeadPage ldp=new LeadPage(driver);
		boolean val =ldp.verifyLeadCreationWithMandatoryFields("Modi", "BJP");
		if(val)
		{
		logger.log(LogStatus.PASS, "Lead success");
		}
		else
		{
		logger.log(LogStatus.FAIL, "Lead not success");
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
