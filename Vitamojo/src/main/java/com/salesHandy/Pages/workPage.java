/**
 * 
 */
package com.salesHandy.Pages;



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
import com.salesHandy.Testcases.GlobalVariable;
import com.salesHandy.Testcases.TestCase1;

import net.bytebuddy.asm.Advice.Enter;
/**
 * @author siddharthj
 *This class will store all the locators and methods of Fleet studio Work Page (POM)
 */
public class workPage extends TestCase1 {
	
	public static ExtentTest test1;
	 ExtentTest Loggers;
	 ExtentReports report;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	By Feature = By.xpath("//section[@class='headerTop']//a[text()='Features']");
	By Email_Sequence = By.xpath("//*[@class='sub-menu']//*[text()='Automate your cold email outreach to scale']");
	By SignUp = By.xpath("//a[@class='elementor-button elementor-size-sm']//span[text()='Sign up for free']");
	By EnterEmail = By.xpath("/html/body/div[4]/div[2]/div/section/div/div[2]/div/div[5]/div/div/div/div[1]/input");
	
	
	
	
	
	public workPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void navigatEmailSequence() {
		driver.findElement(Feature).click();
		
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email_Sequence));
		
		driver.findElement(Email_Sequence).click();
		
	}
	
	
	public void emailonSignUpPage() {
		driver.findElement(SignUp).click();
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EnterEmail));
		
		driver.findElement(EnterEmail).sendKeys("jain.siddharth91@hotmail.com");
		}
		


	public void VerifyDestinationURL() {
		driver.get("https://www.saleshandy.com/cold-emailing/");
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignUp));
		System.out.println("Use of Explicit wait");
		String URL1 = driver.getCurrentUrl();
		System.out.println(URL1);
		
		if(URL1.equalsIgnoreCase("https://www.saleshandy.com/cold-emailing/")) {
			System.out.println("Landed on Email Sequence page Page successfully");
		}
		else{
			System.out.println("Landed on incorrect page");
		}	
		
		
	}
	
	
	
	
}
