package com.clipboardHealth.Testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.clipboardHealth.Pages.workPage;
/**
 * @author siddharthj
 * To class will work as POM as well as Generate the reports as well.
 */

public class ExtentReportTestNG {
	public static ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	
	@BeforeSuite
	public void setup() {	
		  htmlReporter = new ExtentHtmlReporter("ExtentReport_Amazon.html");
	      extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {
	      System.setProperty("webdriver.chrome.driver", GlobalVariable.driverPath);
	      driver =new ChromeDriver();
	      
	}
	 
	@Test
	public void test1() throws IOException {
        ExtentTest test = extent.createTest("Amazon", "Amazon verification");
        driver.manage().window().maximize();
		driver.get(GlobalVariable.URL);
		workPage work =new workPage(driver);
		
		work.verifyNavigation();
		test.log(Status.PASS, "Navigation is successfull");
		work.selectBrand();
		test.log(Status.PASS, "Brand selection is successfull");
		work.sorting();
		test.log(Status.PASS, "Sorting is successfull");
		work.selectingProduct();
		test.log(Status.PASS, "Second Highest Price product selection is successfull" );
		work.assertAboutItem();
		test.log(Status.PASS, "About Us text found" );
	}
	
	

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
	
	@AfterSuite
	public void tearDown() {
	    extent.flush();
	}
	
}
