package com.crm.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.Screenshots;
import com.crm.util.TestUtil;

public class LoginPageTest extends BaseTest {

	public LoginPage logpag;
	public HomePage hompag;


	@Test(priority=1, enabled=false)
	public void loginPageTitleTest() throws IOException{
		logpag = new LoginPage();
		String logi =logpag.validateLoginPageTitle();
		Assert.assertEquals(logi, "Cogmento CRM and Business Cloud Solutions");
	}

	@Test(priority=2)
	public void loginTest() throws IOException, InterruptedException{
		logpag = new LoginPage();
		hompag = logpag.login(TestUtil.getProp("username").toString() , TestUtil.getProp("password").toString());

		String chek= driver.findElement(By.xpath("//span[@class='user-display']")).getText();
		Assert.assertEquals(chek, "Abhi Lanss", "Login Failed");
		
	}



}
