package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.BaseTest;


public class ContactPage extends BaseTest {
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	@CacheLookup  
	WebElement newBtn;
	
	//Main reason to use Page factory is bcoz it has cache memory
	//ele stored in cache memory and easy to check using @CacheLookup
	//it here instead of checking it at browser
	//but cause stale ele exception error if dom is changed
	//use only if the ele never changes
	
	
	//We can use how class to find an ele if we want
	@FindBy(how=How.XPATH, using="//input[@name='first_name']")
	WebElement uFirstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement uLastName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement clickSavebtn;
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")
	WebElement compBtn;
	
	
	@FindBy(xpath="//div[@class='ui basic button floating item dropdown']")
	WebElement clickOnGear;
	
	
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement cliLogOutBtn;
	
	
	//We have to initialize PageFactory with constructor to find ele in dom
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String ftName, String ltName) throws InterruptedException{
		newBtn.click();
		Thread.sleep(3000);
		driver.get(driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.navigate().to("https://ui.cogmento.com/contacts/new");
		Thread.sleep(3000);
		uFirstName.sendKeys(ftName);
		uLastName.sendKeys(ltName);
		clickSavebtn.click();
		Thread.sleep(3000);
		clickOnGear.click();
		Thread.sleep(2000);
		cliLogOutBtn.click();
		
		
		
	}
	
	public CompanyPage clickonCmpPage(){
		compBtn.click();
		return new CompanyPage();					
	}
	

	
	
}
