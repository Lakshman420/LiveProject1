package com.w2a.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private By customerLogin = By.cssSelector("div.borderM.box.padT20 > div:nth-child(1) > button");
	private By bankManagerLogin = By.cssSelector("div.borderM.box.padT20 > div:nth-child(3) > button");
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement verify_CustomerLogin() {
		return driver.findElement(customerLogin);
	}
	public WebElement verify_BankManagerLogin() {
		return driver.findElement(bankManagerLogin);
	}
}
