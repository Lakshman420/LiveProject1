package excercise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Page5 {
	@BeforeTest
	public void setUpBT() {
		System.out.println("Before Test Page4");
	}
	
	@BeforeMethod
	public void setUpBM() {
		System.out.println("Before Method Page4");
	}
	@Test(groups={"Regression","Functional"})
	public void testexecution() {
		System.out.println("Test Page4");
	}
	
	@AfterMethod
	public void tearDownBM() {
		System.out.println("After Method Page4");
	}
	
	@AfterTest
	public void tearDownAT() {
		System.out.println("After Test Page4");
	}
}
