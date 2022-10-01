package com.qaselenium.testscirpts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UrbanLadderMenus {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.urbanladder.com/");
		List<WebElement> menu = driver.findElements(By.xpath("//ul[@class='topnav bodytext']/li/span"));
		Actions act=new Actions(driver);
		for(int i=0;i<=(menu.size()-1);i++) {
			act.moveToElement(menu.get(i)).perform();
			String m=menu.get(i).getText();
			System.out.println(m+"==>");
			Thread.sleep(2000);
			List<WebElement> headers = driver.findElements(By.xpath("//span[contains(text(),'"+m+"')]/../descendant::ul[@class='taxonslist']/descendant::span"));
			for (int j = 0; j<=(headers.size()-1); j++) {
				System.out.println(headers.get(j).getText());
			}
			}
		}
	}
