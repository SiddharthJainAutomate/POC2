package com.salesHandy.Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesHandy.Pages.workPage;
/**
 * @author siddharthj
 * To class will work as POM as well as Generate the reports as well.
 */

public class TestCase1 {
	public static ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	
	@BeforeSuite
	public void setup() {	
		  htmlReporter = new ExtentHtmlReporter("ExtentReport_SalesHandy.html");
	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	}
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUpTest(String browser) {
		System.out.println("Running Browser is " + browser);
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", GlobalVariable.driverPath);
		    driver =new ChromeDriver();
	        driver.manage().window().maximize();
			driver.get("https://careers.vitamojo.com/");
		   
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", GlobalVariable.driverPath1);
		    driver =new FirefoxDriver();   
		}
		 
		
	}
	 
	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("Sales Handy POC on", "Email Sequence page verification");
        driver.manage().window().maximize();
		driver.get(GlobalVariable.URL);
		workPage work =new workPage(driver);
		work.navigatEmailSequence();
		test.log(Status.PASS, "Navigated and landed on Email Sequence page successfully");
		work.VerifyDestinationURL();
		test.log(Status.PASS, "URL of Email Sequence page verified successfully");
		work.emailonSignUpPage();
		test.log(Status.PASS, "Email entered successfully");	
	}
	
	
	
	@AfterTest
	public void tearDownTest() {
		//driver.close();
		//driver.quit();
		System.out.println("Test completed successfully");
	}
	
	@AfterSuite
	public void tearDown() {
	    extent.flush();
	}
	
	
	
	

}
