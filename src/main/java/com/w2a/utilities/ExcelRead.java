package com.w2a.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelRead {
	public static File file = null;
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public String path;

	public ExcelRead(String path) {
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

	public Object getData(String sheetName, int colNum, int rowNum) {
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
		//System.out.println(row.getCell(colNum));
		cell = row.getCell(colNum);
		if (cell.getCellType() == CellType.STRING) {
			data = cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			data = String.valueOf(cell.getNumericCellValue());
			data = data.toString();
			if (DateUtil.isCellDateFormatted(cell)) {
				DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
				Date d = cell.getDateCellValue();
				data = df.format(d);
			}

		} else
			data = "";

		return data;
	}

	

	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			//System.out.println(sheet.getLastRowNum() + ": LastRowNum");
			int rowCount = sheet.getLastRowNum() + 1;
			return rowCount;
		}
	}

	public int getColumnCount(String sheetName) {
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
