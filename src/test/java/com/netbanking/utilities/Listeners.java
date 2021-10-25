package com.netbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.netbanking.testcases.Base;

public class Listeners extends TestListenerAdapter
{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onTestSuccess(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, "test case passed is"+tr.getName());
	}
	
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		String screenshotpath;
		test.log(Status.FAIL,"test case failed is"+tr.getName());
		test.log(Status.FAIL,"test case failed is"+tr.getThrowable());
		try {
			screenshotpath = Base.getScreenshot();
			System.out.println(screenshotpath);
			test.addScreenCaptureFromPath(screenshotpath);
			/*File f = new File(screenshotpath);
			if(f.exists())
			{
			  test.fail("screenshot is below " + test.addScreenCaptureFromPath(screenshotpath));
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void onTestSkipped(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, "test case skipped is"+tr.getName());		
	}
	
	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname = "Test-report-"+timestamp+".html";
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\extents_reports\\"+repname);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\configuration\\extent-config.xml");
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("TestNG Automation testing report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "atul");
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
}
