package com.api.utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name="userData")
	public String[][] getUserData() {
		String fileName = System.getProperty("user.dir")+"//TestData//userData.xlsx";
		int totalRowNum = ReadExcelFile.getRowCount(fileName, "sheet1");
		int totalColumnNum = ReadExcelFile.getColumnCount(fileName, "sheet1");
		
		String data[][] = new String[totalRowNum-1][totalColumnNum];
		
		for(int row=1;row<totalRowNum;row++) {
			for(int column=0;column<totalColumnNum;column++) {
				data[row-1][column]= ReadExcelFile.getCellValue(fileName, "sheet1", row, column);
			}
		}
		return data;
	}
	
	@DataProvider(name="username")
	public String[] getUserNameDataProvider() {
		String fileName = System.getProperty("user.dir")+"//TestData//userData.xlsx";
		int totalRowNum = ReadExcelFile.getRowCount(fileName, "sheet1");
		
		String userNames[] = new String[totalRowNum-1];
		
		for(int row=1;row<totalRowNum;row++) {
			userNames[row-1] = ReadExcelFile.getCellValue(fileName, "sheet1", row, 1);
		}
		return userNames;
	}

}
