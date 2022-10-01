package com.qaselenium.testscirpts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testpages.herokuapp.com/file_upload_j.html");
		WebElement upload=driver.findElement(By.id("fileinput"));
		upload.sendKeys("‪C:\\Users\\Samartha\\Desktop\\Demo.txt");
	}

}
