package excercise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Page1 {
	
	@BeforeTest
	public void setUpBT() {
		System.out.println("Before Test Page1");
	}
	
	@BeforeMethod
	public void setUpBM() {
		System.out.println("Before Method Page1");
	}
	@Parameters({"myname"})
	@Test(dependsOnMethods= {"testexecutionTest2"})
	//(groups= {"Regression"})
	public void testexecutionTest1() {
		System.out.println("Test1 Page1");
		
	}
	
	@Parameters({"myName"})
    @Test
	//(groups= {"Regression"})
	public void testexecutionTest2(String name) {
		System.out.println("Test2 Page1");
		System.out.println(name);
	}
	
	@AfterMethod
	public void tearDownBM() {
		System.out.println("After Method Page1");
	}
	
	@AfterTest
	public void tearDownAT() {
		System.out.println("After Test Page1");
	}
}
