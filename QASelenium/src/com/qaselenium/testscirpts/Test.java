package com.qaselenium.testscirpts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://courses.letskodeit.com/practice");
		WebElement dropdown = driver.findElement(By.id("multiple-select-example"));
		Select sel=new Select(dropdown);
		sel.selectByValue("apple");
		sel.selectByVisibleText("Orange");
		sel.selectByIndex(2);
		Thread.sleep(3000);
		sel.deselectAll();
	}

}
