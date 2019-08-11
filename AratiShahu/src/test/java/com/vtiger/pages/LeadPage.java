package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadPage extends HeaderPage  {

	
public WebDriver driver;
	
	public LeadPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	By lname=By.name("lastname");
	By comp=By.name("company");
	By save=By.name("button");
	
	
	public void LeadCreationWithMandatoryFields(String lastname, String cname)
	{
		driver.findElement(lname).sendKeys(lastname);
		driver.findElement(comp).sendKeys(cname);
		driver.findElement(save).click();		
	}
	
	public boolean verifyLeadCreationWithMandatoryFields(String lastname, String cname)
	{
		LeadCreationWithMandatoryFields(lastname,cname);
		if(driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals(lastname))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
