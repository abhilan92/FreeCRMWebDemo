package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.BaseTest;

public class HomePage extends BaseTest {

	
	//Once logged in, put all the elements 
	
	
	//Calender Tab
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement caledBtn;
	
	//Contacts Tab
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactBtn;
	
	//Companies Tab
	@FindBy(xpath="//span[contains(text(), 'Companies')]")
	WebElement compBtn;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	
	
	public ContactPage clickonContact(){
		contactBtn.click();
		return new ContactPage();
		
	}
	
	
	public CompanyPage clickonComp(){
		compBtn.click();
		return new CompanyPage();
	}
	
	
}
