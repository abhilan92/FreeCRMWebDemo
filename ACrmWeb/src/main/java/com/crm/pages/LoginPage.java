package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.BaseTest;

public class LoginPage extends BaseTest {

	//Using Page Factory - Object Repository
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement logmebtn;
	
	public @FindBy(name="email")
	WebElement username;
	
	//using private for encapsulation i.e. security 
	private @FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbutton;
	
	//Setup Page Factory to use the Elements
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String up) throws InterruptedException{
		logmebtn.click();
		Thread.sleep(2000);
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(up);
		loginbutton.click();
		return new HomePage();
	}
	
}
