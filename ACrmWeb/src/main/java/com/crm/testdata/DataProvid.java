package com.crm.testdata;

import org.testng.annotations.DataProvider;

import com.crm.base.BaseTest;
import com.crm.util.ExcelFile;

public class DataProvid extends BaseTest{
	
	public static String sheetName = "contacts";
	
	@DataProvider(name="gCRMTestData")
	public static Object[][] getCRMTestData(){
		Object data[][] = ExcelFile.getTestData(sheetName);
		return data;
	}
	

}
