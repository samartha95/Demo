package com.qaselenium.tesnng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddToCart extends Base{
	@Test
	public void addToCartTest() {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Nexus 6']"))));
		for(int i=0;i<3;i++) {
			try {
			driver.findElement(By.xpath("//a[text()='Nexus 6']")).click();
			break;
			}
			catch (StaleElementReferenceException e) {
				
			}
		}
		Reporter.log("Clicked on the product",true);
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		Reporter.log("added the product to the cart",true);
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		Reporter.log("Navigated to cart",true);
	
	}
	
}
