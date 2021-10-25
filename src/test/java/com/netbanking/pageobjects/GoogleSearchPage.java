package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage
{
	WebDriver ldriver=null;
	
	public GoogleSearchPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="q")
	WebElement searchbox;
	
	@FindBy(xpath = "//a[text()=\"Gmail\"]")
	WebElement gmail_link;
	
	@FindBy(xpath = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]")
	WebElement searchbtn;
	
	@FindBy(xpath = "//a[text()=\"मराठी\"]")
	WebElement lang_marathi;
	
	public void search(String searchstring)
	{
		searchbox.sendKeys(searchstring);
	}
	
	public void clickgmail()
	{
		gmail_link.click();
	}
	
	public void clicksearchbtn()
	{
		searchbtn.click();
	}
	
	public void clicklanguage()
	{
		lang_marathi.click();
	}
}

