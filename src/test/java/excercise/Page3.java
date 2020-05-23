package excercise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Page3 {
	@BeforeTest
	public void setUpBT() {
		System.out.println("Before Test Page3");
	}
	
	@BeforeMethod
	public void setUpBM() {
		System.out.println("Before Method Page3");
	}
	@Test(groups= {"Functional"})
	public void testexecution() {
		System.out.println("Test Page3");
	}
	
	@AfterMethod
	public void tearDownBM() {
		System.out.println("After Method Page3");
	}
	
	@AfterTest
	public void tearDownAT() {
		System.out.println("After Test Page3");
	}
}
