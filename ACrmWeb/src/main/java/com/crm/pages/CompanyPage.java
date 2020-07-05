package com.crm.pages;

import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.BaseTest;

public class CompanyPage extends BaseTest{

	
	@FindBy(xpath="//button[contains(text(),'New')]")
	@CacheLookup
	WebElement cmpyNewBtn;
	
	@FindBy(xpath="//div[@class='ui right corner labeled input']//input[@name='name']")
	@CacheLookup
	WebElement unam;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement usav;
	
	public CompanyPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void createNewComp() throws InterruptedException{
		cmpyNewBtn.click();
		Thread.sleep(3000);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n Enter your Company Name: ");
		String name = scanner.nextLine();
		unam.sendKeys(name);
		usav.click();
		
	}
	
}
