package excercise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Page2 {

	@BeforeTest
	public void setUpBT() {
		System.out.println("Before Test Page2");
	}
	
	@BeforeMethod
	public void setUpBM() {
		System.out.println("Before Method Page2");
	}
	@Test(groups={"Regression"})
	public void testexecution() {
		System.out.println("Test Page2");
	}
	
	@AfterMethod
	public void tearDownBM() {
		System.out.println("After Method Page2");
	}
	
	@AfterTest
	public void tearDownAT() {
		System.out.println("After Test Page2");
	}
}
