package com.netbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPage;
import com.netbanking.utilities.XLUtils;

public class DataDrivenTest extends Base
{
		
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com.netbanking.testdata\\test_data.xlsx";
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return logindata;
	}
	
	
	@Test(dataProvider = "LoginData")
	public void LoginDDT(String username, String password) throws InterruptedException
	{
		driver.get(baseurl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Thread.sleep(2000);
			Reporter.log("test case passed");
			lp.clicklogout();
		}
		else
		{
			Assert.assertTrue(false);
			Thread.sleep(2000);
			Reporter.log("test case failed");
		}
	}

}
