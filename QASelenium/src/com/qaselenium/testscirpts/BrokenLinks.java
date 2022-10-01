package com.qaselenium.testscirpts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", GenericMethods.getDataFromProperties("Resources/TestData.properties", "chromedriver"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys(GenericMethods.getDataFromExcel("C:\\Users\\Samartha\\Desktop\\Test.xlsx", "TestData", 3, 0),Keys.ENTER);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement l : links) {
			String link = l.getAttribute("href");
			if(link==null) {
				System.out.println("No link attached");
			}
			else {
				URL url=new URL(link);
				HttpURLConnection connection=(HttpURLConnection)url.openConnection();
				connection.connect();
				if(connection.getResponseCode()>=400) {
					System.out.println(link+" is broken");
				}
				else {
					System.out.println(link+" is valid");
				}
			}
		}

	}

}
