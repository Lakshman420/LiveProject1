package com.w2a.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.w2a.pages.AddCustomer;
import com.w2a.pages.BankManagerLoginPage;
import com.w2a.pages.LoginPage;
import com.w2a.utilities.Base;
import com.w2a.utilities.DataProviders;

public class TestCase_03 extends Base{
	WebDriver driver;

	@BeforeTest
	public void SetUp() {
		driver = driverInitialization();
		LoginPage lp = new LoginPage(driver);
		lp.verify_BankManagerLogin().click();
		log.debug("Bank Manager Login page is successfully opened");
		Reporter.log("Bank Manager Login page is successfully opened");
		BankManagerLoginPage bmlp = new BankManagerLoginPage(driver);
		bmlp.verifyToAddCustomer().click();
		log.debug("Add customer page is successfully opened");
		Reporter.log("Add customer page is successfully opened");
	}

	@Test(dataProvider="AddCustomer",dataProviderClass=DataProviders.class)
	public void addCustomer(String fName, String lName, String pcode) {
		
		AddCustomer ac = new AddCustomer(driver);
		ac.firstNamedata().sendKeys(fName);
		ac.lastNamedata().sendKeys(lName);
		ac.pincodedata().sendKeys(pcode);
		ac.addButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
