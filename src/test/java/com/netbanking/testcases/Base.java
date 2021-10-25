package com.netbanking.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.netbanking.utilities.ReadConfig;

public class Base {

	public static WebDriver driver;
	public String baseurl;	
	public String username;
	public String password;
	public static Logger logger;
	
	@BeforeClass
	public void setup() throws IOException
	{
		logger = LogManager.getLogger(com.netbanking.testcases.Base.class.getName());
		ReadConfig readconfig = new ReadConfig();
	    String browser = readconfig.getbrowser();
	    username = readconfig.getusername();
	    password = readconfig.getpaswword();
	    baseurl = readconfig.getbaseurl();
	    if(browser.equalsIgnoreCase("chrome"))
	    {
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		driver = new ChromeDriver();
		logger.info("chrome browser started");
		driver.manage().window().maximize();
	    }
	    else if(browser.equalsIgnoreCase("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
			logger.info("firefox browser started");
			driver.manage().window().maximize();
	    }
	    else if(browser.equalsIgnoreCase("ie"))
	    {
	    	System.setProperty("webdriver.ie.driver", readconfig.getiepath());
			driver = new InternetExplorerDriver();
			logger.info("ie browser started");
			driver.manage().window().maximize();
	    }
	    else if(browser.equalsIgnoreCase("edge"))
	    {
	    	System.setProperty("webdriver.edge.driver", readconfig.getedgepath());
			driver = new EdgeDriver();
			logger.info("edge browser started");
			driver.manage().window().maximize();
	    }
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
		logger.info("browser closed");
	}
	
	public static String getScreenshot() throws IOException
	{
		String datename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+datename+".png";
		File filedest = new File(destination);
		FileUtils.copyFile(source, filedest);
		return destination;
	}
}
