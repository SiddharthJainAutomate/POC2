package com.salesHandy.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class crossBrowser {

	WebDriver driver;
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUpTest(String browser) {
		
		System.out.println("Running Browser is " + browser);
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", GlobalVariable.driverPath);
		    driver =new ChromeDriver();
		   
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", GlobalVariable.driverPath1);
		    driver =new FirefoxDriver();   
		   
		}
		 

        driver.manage().window().maximize();
		driver.get(GlobalVariable.URL);
		
	}
	
	
}
