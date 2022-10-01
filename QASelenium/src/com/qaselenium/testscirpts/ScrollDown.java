package com.qaselenium.testscirpts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		JavascriptExecutor je=(JavascriptExecutor)driver;
		int y=driver.findElement(By.xpath("//a[text()='Contact Us']")).getLocation().getY();
		je.executeScript("window.scroll(0,"+y+")");
		

	}

}
