package com.crm.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.ContactPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.testdata.DataProvid;
import com.crm.util.ExcelFile;
import com.crm.util.TestUtil;

public class ContactPageTest extends BaseTest {
	
	public LoginPage logpag;
	public HomePage hompag;
	public ContactPage contpag;
	public static String sheetName = "contacts";
	
	@Test(dataProvider="gCRMTestData", dataProviderClass=DataProvid.class)
	public void validateCreateNewContact(String firstName, String lastName) throws InterruptedException, IOException{
		logpag = new LoginPage();
		hompag = logpag.login(TestUtil.getProp("username").toString() , TestUtil.getProp("password").toString());
		contpag = hompag.clickonContact();
		Thread.sleep(1000);
		contpag.createNewContact(firstName,lastName);
		
	}

	
}
