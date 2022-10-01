package com.qaselenium.testscirpts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableCricInfo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stats.espncricinfo.com/cricinfoat20/content/records/211608.html");
		JavascriptExecutor je=(JavascriptExecutor) driver;
		List<WebElement> names = driver.findElements(By.xpath("//tr/td[5]/a"));
		List<WebElement> TotalDeliveries = driver.findElements(By.xpath("//tr/td[2]"));
		for(int i=0;i<(names.size()-1);i++) {
			int y=names.get(i).getLocation().getY();
			je.executeScript("window.scroll(0,"+y+")");
			String player=names.get(i).getText();
			String deliveries=TotalDeliveries.get(i).getText();
			System.out.print(player+"==>");
			System.out.println(deliveries);
		}
		driver.close();
	}
}
