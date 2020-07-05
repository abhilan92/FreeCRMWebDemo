package com.crm.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.ContactPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;


//C:\Windows\SysWOW64\config\systemprofile\.jenkins
//Jenkins path

public class HomePageTest extends BaseTest {

	public LoginPage logpag;
	public HomePage hompag;
	public ContactPage contpag;


	@Test
	public void verifyHomePageTitle() throws InterruptedException, IOException{

		org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("HomePageTest");

		PropertyConfigurator.configure("./Config/Log4j.properties");

		log.info("Driver is initialized");
		
		logpag = new LoginPage();

		log.info("Navigated to Home page");
		
		hompag = logpag.login(TestUtil.getProp("username").toString() , TestUtil.getProp("password").toString());

		String title1 = hompag.validateHomePageTitle();
		
		Assert.assertEquals(title1, "Cogmento CRM", "Title not match");
		
		contpag = hompag.clickonContact();

		//String filePath = System.getProperty("user.home")+"/Downloads/Code.txt";

		//com.crm.util.EmailAttachs.sendAttachEmail(filePath);

		log.info("Driver is Closed");

	}

}
