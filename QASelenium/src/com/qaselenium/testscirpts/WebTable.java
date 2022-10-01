package com.qaselenium.testscirpts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		String x="Italy";
		System.out.println(rows.size());
		for(int i=1;i<=(rows.size()-1);i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			for(int j=1;j<2;j++) {
				String data =cells.get(j).findElement(By.tagName("strong")).getText();
				if(data.equals(x)) {
					System.out.println("Row number==>"+i);
					System.out.print(cells.get(j).getText());
					System.out.print("  "+cells.get(j+1).getText());
					System.out.print("  "+cells.get(j+2).getText());
					System.out.print("  "+cells.get(j+3).getText());
					i=rows.size();
				}
			}
			
		}
		

	}

}
