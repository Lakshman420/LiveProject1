package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomer {
	WebDriver driver;
	private By fName = By.xpath("//input[@ng-model='fName']");
	private By lName = By.xpath("//input[@ng-model='lName']");
	private By pcode = By.xpath("//input[@ng-model='postCd']");
	private By add = By.cssSelector("button[type='submit']");
		public AddCustomer(WebDriver driver) {
			this.driver = driver;
		}
		
		public WebElement firstNamedata() {
			return driver.findElement(fName);
			
		}
		public WebElement lastNamedata() {
			return driver.findElement(lName);
			
		}
		public WebElement pincodedata() {
			return driver.findElement(pcode);
		}
		public WebElement addButton() {
			return driver.findElement(add);
		}
		
}
