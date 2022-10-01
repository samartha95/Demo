package com.qaselenium.testscirpts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpinnyDropDownMenus {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samartha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spinny.com/");
		List<WebElement> menu = driver.findElements(By.xpath("//ul[@class='styles__pageViewportWrapper ExploreBy__exploreItemList']/li"));
		Actions act=new Actions(driver);
		for(int i=1;i<=(menu.size()-1);i++) {
			act.moveToElement(menu.get(i)).perform();
			String m=menu.get(i).getText();
			System.out.println(m+"==>");
			List<WebElement> submenu = driver.findElements(By.xpath("//ul[@class='styles__pageViewportWrapper ExploreBy__exploreItemList']/li[text()='"+m+"']/descendant::span"));
			for(int j=0;j<=(submenu.size()-1);j++) {
				System.out.println(submenu.get(j).getText());
			}
		}
		
		
	}

}
