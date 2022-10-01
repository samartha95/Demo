package com.qaselenium.tesnng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qaselenium.testscirpts.GenericMethods;

public class Base {
	static WebDriver driver;
	static String properties ="Resources/TestData.properties";
	SoftAssert sa=new SoftAssert();
	
	@BeforeTest
	public void configBT() throws IOException {
		if(GenericMethods.getDataFromProperties(properties, "browser").equals("chrome")){
			driver=new ChromeDriver();
			Reporter.log("Launched the browser",true);
		}
		if(GenericMethods.getDataFromProperties(properties, "browser").equals("edge")){
			driver=new EdgeDriver();
			Reporter.log("Launched the browser",true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
		Reporter.log("Navigated to URL", true);
	}
	
	@BeforeMethod
	public void configBC() throws IOException {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("loginusername")).sendKeys(GenericMethods.getDataFromProperties(properties, "username"));
		driver.findElement(By.id("loginpassword")).sendKeys(GenericMethods.getDataFromProperties(properties, "password"));
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Reporter.log("Logged in to the app as "+GenericMethods.getDataFromProperties(properties, "username"),true);
	}
	
	
	@AfterMethod
	public void configAC() {
		int i=0;
		while(i<3) {
			try {
			driver.findElement(By.xpath("//a[text()='Log out']")).click();
			Reporter.log("Logged out from the app",true);
			break;
			}
			catch(StaleElementReferenceException e) {
				i=i+1;
			}
		}
	}
	
	@AfterTest
	public void configAT() {
		driver.quit();
		Reporter.log("CLosed the browser",true);
		sa.assertAll();
	}
	
	
}
