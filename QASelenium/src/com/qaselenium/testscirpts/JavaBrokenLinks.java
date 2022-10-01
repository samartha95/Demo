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

public class JavaBrokenLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int validLinks=0;
		int BrokenLinks=0;
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("java",Keys.ENTER);
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		for(WebElement l:links) {
			String link = l.getAttribute("href");
			if(link==null) {
				System.out.println("No link available");
			}
			else {
				try {
					URL url=new URL(link);
					HttpURLConnection connection=(HttpURLConnection)url.openConnection();
					connection.connect();
					if(connection.getResponseCode()>=400) {
						System.out.println(link+"===>"+"is Broken");
						BrokenLinks=BrokenLinks+1;
					}
					else {
						System.out.println(link+"==>is a valid link");
						validLinks=validLinks+1;
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Total number of valid links==>"+validLinks);
		System.out.println("Total number of valid links==>"+BrokenLinks);
	}

}
