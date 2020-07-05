package com.crm.base;




//Testing websites
//https://rahulshettyacademy.com/#/practice-project
//http://www.way2automation.com/demo.html
//https://phptravels.com/demo/
//https://ca.cogmento.com/index.html
//http://automationpractice.com/index.php
//https://opensource-demo.orangehrmlive.com/





import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.crm.util.TestUtil;
import com.crm.util.WebEventList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventList eventListener;
	
	@BeforeMethod
	public static void browserSetup() throws IOException{
		
		if(TestUtil.getProp("browserName").toString().equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (TestUtil.getProp("browserName").toString().equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "D:\\Edu Stuff\\Selenium\\Selenium Softs\\Other Softs\\Drivers\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		else if (TestUtil.getProp("browserName").toString().equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventList();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(TestUtil.getProp("urlMainPage").toString());
		
	}
	
	@AfterMethod
	public void bClose() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	

}
