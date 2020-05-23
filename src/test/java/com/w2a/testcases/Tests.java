package com.w2a.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.pages.AddCustomer;
import com.w2a.utilities.Base;

public class Tests extends Base {
	public WebDriver driver;
	File file = null;
	FileInputStream fis = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	String path = System.getProperty("user.dir") + "\\resources\\ExcelData.xlsx";
	String sheetName = "addCustomer";

	@BeforeTest
	public void setUp() {
		this.driver = driverInitialization();
		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust");
	}

	@Test(dataProvider = "DP")
	public void addCustomer(String fName, String lName, String pcode) {
		AddCustomer ac = new AddCustomer(driver);
		ac.firstNamedata().sendKeys(fName);
		ac.lastNamedata().sendKeys(lName);
		ac.pincodedata().sendKeys(pcode);
		ac.addButton().click();

		driver.switchTo().alert().accept();

	}

	@DataProvider(name = "DP")
	public Object[][] getData() {
		ExcelRead(path);

		int rowCount = getRowCount(sheetName);
		System.out.println(rowCount);
		int columnCount = getColumnCount(sheetName);
		System.out.println(columnCount);

		Object[][] data = new Object[rowCount - 1][columnCount];
		for (int rowNum = 1; rowNum < rowCount; rowNum++) {
			for (int colNum = 0; colNum < columnCount; colNum++) {

				data[rowNum - 1][colNum] = getDataFromExcel(sheetName, colNum, rowNum);

			}
		}
		return data;

	}

	private Object getDataFromExcel(String sheetName, int colNum, int rowNum) {
		String data = null;
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return "";
		}
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		if (row == null) {
			return "";
		}
		System.out.println(row.getCell(colNum));
		cell = row.getCell(colNum);
		if (cell.getCellType() == CellType.STRING) {
			data = cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			data = String.valueOf(cell.getNumericCellValue());

			if (DateUtil.isCellDateFormatted(cell)) {
				DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
				Date d = cell.getDateCellValue();
				data = df.format(d);
			}

		} else
			data = "";

		return data;
	}

	void ExcelRead(String path) {
		this.path = path;
		file = new File(path);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			System.out.println(sheet.getLastRowNum() + ": LastRowNum");
			int rowCount = sheet.getLastRowNum() + 1;
			return rowCount;
		}
	}

	int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			row = sheet.getRow(0);
			int columnCount = row.getLastCellNum();
			return columnCount;
		}

	}
}