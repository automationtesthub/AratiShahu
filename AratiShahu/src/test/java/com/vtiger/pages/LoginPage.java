package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username= By.name("user_name");
	By pwd= By.name("user_password");
	By login= By.name("Login");
	By logo= By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	By errormsg= By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
	
	
	public boolean verifyTitle(String exp)
	{
		if(driver.getTitle().equals(exp))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean verifylogo()
	{
		if(driver.findElement(logo).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean InvalidLogin(String uname, String upassword)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys(upassword);
		driver.findElement(login).click();
		if(driver.findElement(errormsg).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public HomePage validLogin(String uname, String upassword)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys(upassword);
		driver.findElement(login).click();
		return new HomePage(driver);
	}

	
	
	
	
	
	

}
