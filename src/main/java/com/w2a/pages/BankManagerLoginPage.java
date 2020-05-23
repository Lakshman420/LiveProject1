package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankManagerLoginPage {
	private By addcustomer = By.cssSelector("button[ng-class='btnClass1']");
	private By openaccount = By.cssSelector("button[ng-class='btnClass2']");
	private By customers = By.cssSelector("button[ng-class='btnClass3']");
	WebDriver driver;
	
	public BankManagerLoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement verifyToAddCustomer() {
		return driver.findElement(addcustomer);
	}
	public WebElement verifyToOpenAccount() {
		return driver.findElement(openaccount);
	}
	public WebElement verifyCustomers() {
		return driver.findElement(customers);
	}
}
