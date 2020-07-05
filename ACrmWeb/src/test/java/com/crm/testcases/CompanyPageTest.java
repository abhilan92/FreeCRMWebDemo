package com.crm.testcases;

import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.CompanyPage;
import com.crm.pages.ContactPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.testdata.DataProvid;
import com.crm.util.TestUtil;

public class CompanyPageTest extends BaseTest {
	
	public LoginPage logpag;
	public HomePage hompag;
	public ContactPage contpag;
	public CompanyPage companyPage;
	
	
	@Test
	public void beOnCompPage() throws InterruptedException, IOException{
		logpag = new LoginPage();
		hompag = logpag.login(TestUtil.getProp("username").toString() , TestUtil.getProp("password").toString());
		Thread.sleep(1000);
		companyPage = new CompanyPage();
		companyPage = hompag.clickonComp();
		Thread.sleep(2000);
		companyPage.createNewComp();
	
	}
	
	
	
	
	
}
