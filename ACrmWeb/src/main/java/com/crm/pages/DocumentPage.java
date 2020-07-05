package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.BaseTest;

public class DocumentPage extends BaseTest {
	
	@FindBy(xpath="//a[contains(text(),'Exports')]")
	WebElement expBtn;
	
	@FindBy(xpath="//div[@class='ui cards']//div[1]//div[2]//div[2]//a[1]")
	WebElement clicDwnldBtn;
	
	
	
	public DocumentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void onExpt() throws InterruptedException{
		expBtn.click();
		Thread.sleep(2000);
		clicDwnldBtn.click();
	}
	
	
	
	

}
