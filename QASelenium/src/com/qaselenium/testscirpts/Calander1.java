package com.qaselenium.testscirpts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
		driver.switchTo().frame(driver.findElement(By.xpath("//p/iframe")));
		driver.findElement(By.id("datepicker")).click();
		int i=0;
		while(i<12) {
			try {
				driver.findElement(By.xpath("//span[text()='June']")).click();
				driver.findElement(By.xpath("//td/a[text()='24']")).click();
				break;
			}
			catch(NoSuchElementException e) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}

	}

}
