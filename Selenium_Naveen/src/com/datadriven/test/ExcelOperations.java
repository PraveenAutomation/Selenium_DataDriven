package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Dell\\From11Nov2017WebDriver\\Selenium_Naveen\\src\\com\\testdata\\HalfEbayTestData1.xlsx");
		
		//reader.addSheet("HomePage");
		if(!reader.isSheetExist("HomePage"))
		{
			reader.addSheet("HomePage");
		}
		
		int colCount=reader.getColumnCount("RegTestData");
		System.out.println("Column count is:: "+colCount);
		
		System.out.println("Row num is:: "+reader.getCellRowNum("RegTestData", "firstname", "Trivedi"));

	}

}
