package com.api.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName,String sheetName,int rowNo,int cellNo) {
		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			cell = excelSheet.getRow(rowNo).getCell(cellNo);
			workbook.close();
			return cell.getStringCellValue();
			
			
		} catch(Exception e) {
			e.getMessage();
			return "";
		}
		
	}
	
	public static int getRowCount(String fileName,String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			int totalRowCount = excelSheet.getLastRowNum()+1;
			workbook.close();
			return totalRowCount;
			
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static int getColumnCount(String fileName,String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			int totalColumnCount = excelSheet.getRow(0).getLastCellNum();
			workbook.close();
			return totalColumnCount;
			
		} catch (Exception e) {
			return 0;
		}
	}
}
