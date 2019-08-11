package com.vtiger.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends HeaderPage  {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	

}
