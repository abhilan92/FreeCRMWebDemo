package com.crm.testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.CompanyPage;
import com.crm.pages.ContactPage;
import com.crm.pages.DocumentPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class DocumentPageTest extends BaseTest {

	public LoginPage logpag;
	public HomePage hompag;
	public DocumentPage docuPage;
	
	@Test
	public void beOnCompPage() throws InterruptedException, IOException{
		logpag = new LoginPage();
		hompag = logpag.login(TestUtil.getProp("username").toString() , TestUtil.getProp("password").toString());
		Thread.sleep(1000);
		docuPage = new DocumentPage();
		docuPage= hompag.clickOnDocs();
		Thread.sleep(2000);
		docuPage.onExpt();
		Thread.sleep(2000);
		
		
		String downFile ="export-contact-2020-07-05T140845.xlsx";
		
		String filePath = System.getProperty("user.home")+"/Downloads/"+downFile;

		com.crm.util.EmailAttachs.sendAttachEmail(filePath);
	
	}
	
	
}
