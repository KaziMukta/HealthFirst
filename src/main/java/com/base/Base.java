package com.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.commonMethods.CommonMethods;
import com.logger.Java_Logger;
import com.utils.ReadConfigProp;
import com.webPages.LogIn;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
 protected	WebDriver driver;
 public LogIn logIn;
 public CommonMethods cm;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Java_Logger.getLog("Browser is getting launced");
		driver.get(ReadConfigProp.getInstanceProp().getHealthFirstUrl());
		Java_Logger.getLog("I am on HealthFirst Home Page");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(ReadConfigProp.getInstanceProp().getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(ReadConfigProp.getInstanceProp().getPageLoadWait(), TimeUnit.SECONDS);
		initialization();
	}
	
	@AfterTest 
	public void tearUp() {
		driver.quit();	
		Java_Logger.getLog("Closing the browser");
	}
	private void initialization() {
	 logIn=new LogIn(driver);
	 cm=new CommonMethods();
	}
	
	

}
