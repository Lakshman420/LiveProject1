package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;


public class DataProviders extends Base {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName));

	}
	
	@DataProvider(name ="AddCustomer")
	public Object[][] getData(){
		String sheetName = "addCustomer";
		int rowCount = excel.getRowCount(sheetName);
		int columnCount = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rowCount-1][columnCount];
		for(int rowNum=1; rowNum<rowCount; rowNum++) {
			
			for(int columnNum=0; columnNum<columnCount; columnNum++) {
				
				data[rowNum-1][columnNum] = excel.getData(sheetName, columnNum, rowNum );

			}
		}
		
		return data;
		
	}
	

}
