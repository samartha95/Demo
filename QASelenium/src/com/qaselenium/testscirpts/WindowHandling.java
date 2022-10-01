package com.qaselenium.testscirpts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Iphone 13",Keys.ENTER);
		WebElement mob=driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Midnight, 128 GB)']"));
		String mobile=mob.getText();
		mob.click();
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> ids = tabs.iterator();
		String pid=ids.next();
		String cid=ids.next();
		System.out.println(pid);
		System.out.println(cid);
		driver.switchTo().window(cid);
		String price=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		System.out.print(mobile);
		System.out.println("==>"+price);
		driver.switchTo().window(pid);
		mob.click();
		
	}

}
