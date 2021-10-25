package com.netbanking.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPage;

public class LoginTest extends Base
{

	@Test 
	public void logintest()
	{
		driver.get(baseurl);
		logger.info("opening url");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entering username");
		lp.setPassword(password);
		logger.info("Entering password");
		lp.clickLogin();
		logger.info("clicking login button");
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Reporter.log("test case passed");
		}
		else
		{
			Assert.assertTrue(false);
			Reporter.log("test case failed");
		}
	}
	
}
