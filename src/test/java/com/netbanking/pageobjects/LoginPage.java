package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class LoginPage 
{
      WebDriver ldriver;
      
      public LoginPage(WebDriver rdriver) 
      {
    	  ldriver = rdriver;
    	  PageFactory.initElements(ldriver, this);
      }
      
      @FindBy(name="uid")
      WebElement username;
      
      @FindBy(name="password")
      WebElement password;
      
      @FindBy(name="btnLogin")
      WebElement loginbtn;
      
      @FindBy(how = How.NAME, using="btnReset")
      WebElement resetbtn;
      
      @FindBy(xpath = "//a[contains(text(),'Log out')]")
      WebElement logoutbtn;

	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
      
     public void clickLogin()
     {
    	 loginbtn.click();
     }
     
     public void clickReset()
     {
    	 resetbtn.click();
     }
      
     public void clicklogout()
     {
    	 logoutbtn.click();
    	 ldriver.switchTo().alert().accept();
     }
}
