package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
	
public WebDriver driver;
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By lnkLogout = By.linkText("Logout");
	By lnkNewLead = By.linkText("New Lead");
	
	
	public void clickLogout()
	{
		driver.findElement(lnkLogout).click();
	}
	
	public void clickNewLead()
	{
		driver.findElement(lnkNewLead).click();
	}
	
	public boolean verifyLogout()
	{
		if(driver.findElement(lnkLogout).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
