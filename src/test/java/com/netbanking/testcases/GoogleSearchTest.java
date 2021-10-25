package com.netbanking.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.GoogleSearchPage;

public class GoogleSearchTest extends Base
{
	GoogleSearchPage gsp;

	@Test(priority = 1)
	public void googleserach()
	{
		driver.get("https://www.google.com/");
		gsp = new GoogleSearchPage(driver);
		gsp.search("selenium");
		gsp.clicksearchbtn();
		if(driver.getTitle().contains("selenium"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.navigate().back();
	}
	
	@Test(priority = 2)
	public void gmailclick()
	{
		gsp.clickgmail();
		if(driver.getTitle().contains("Gmail"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}	
		driver.navigate().back();
	}
	
	@Test(priority = 3)
	public void clickmarathi()
	{
		gsp.clicklanguage();
		if(driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[2]")).getAttribute("value").contains("मी भाग्यवान"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}	
	}
}
