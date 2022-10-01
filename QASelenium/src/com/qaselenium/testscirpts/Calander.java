package com.qaselenium.testscirpts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		int i=0;
		while(i<14) {
			try {
				driver.findElement(By.xpath("//span[text()='December']"));
				driver.findElement(By.xpath("//tr/td/a[text()='14']")).click();
				break;
			}
			catch(NoSuchElementException e) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				i++;
			}
		}
	

}}
