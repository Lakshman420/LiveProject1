package com.w2a.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.w2a.pages.LoginPage;
import com.w2a.utilities.Base;

public class TestCase_02 extends Base{
	WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		driver = driverInitialization();
	}
	
	@Test
	public void verifyLoginPage() {
		LoginPage lp = new LoginPage(driver);
		lp.verify_BankManagerLogin().click();
		log.debug("Objects are properly displayed");
		Reporter.log("Objects are properly displayed");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
