/**
 * 
 */
package com.vitamojo.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vitamojo.Testcases.GlobalVariable;
import com.vitamojo.Testcases.HomePage;

import net.bytebuddy.asm.Advice.Enter;
/**
 * @author siddharthj
 *This class will store all the locators and methods of Fleet studio Work Page (POM)
 */
public class workPage extends HomePage {
	
	public static ExtentTest test1;
	 ExtentTest Loggers;
	 ExtentReports report;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	By Accept = By.xpath("//a[contains(text(),'Accept')]");
	By Aboutus = By.xpath("//nav[@role='navigation']//a[contains(text(),'About us')]");
	By Careers = By.xpath("//nav[@role='navigation']//a[contains(text(),'Careers')]");
	By Acceptall = By.xpath("//*[text()='Accept all']");
	By Jobopening = By.xpath("//*[text()='Job openings']");
	By QAautomation = By.xpath("//*[text()='QA Automation Architect']");
	
	
	
	
	public workPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void navigatCareerPage() {
		
		Boolean Display = driver.findElement(Accept).isDisplayed();
		if(Display=true) {
			driver.findElement(Accept).click();
		}
		driver.findElement(Aboutus).click();
	}
	
	
	public void navigateCarrerSection() {
		
		Boolean Display = driver.findElement(Acceptall).isDisplayed();
		if(Display=true) {
			driver.findElement(Acceptall).click();
		}
		driver.findElement(Jobopening).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(QAautomation).click();
		
	}
		


	public void VerifyDestinationURL() {
		driver.get("https://careers.vitamojo.com/");
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Jobopening));
		System.out.println("Use of Explicit wait");
		String URL1 = driver.getCurrentUrl();
		System.out.println(URL1);
		
		if(URL1.equalsIgnoreCase("https://careers.vitamojo.com/")) {
			System.out.println("Landed on Carrer Page");
		}
		else{
			System.out.println("Landed on incorrect page");
		}	
		
		
	}
	
	
	
	
}
