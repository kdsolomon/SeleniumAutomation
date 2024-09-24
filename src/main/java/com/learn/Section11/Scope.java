package com.learn.Section11;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int links=driver.findElements(By.tagName("a")).size();
		System.out.println("Link number is "+links);
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
		int subLinks=footerDriver.findElements(By.tagName("a")).size();
		System.out.println("subLink number is "+subLinks);
		WebElement columndriver=footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int length=columndriver.findElements(By.tagName("a")).size();
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//click on each link and open
		for(int i=1;i<length;i++) {
			
			String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000);
			
		}Set<String> ab= driver.getWindowHandles();
		Iterator<String> it =ab.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
			
			
		
		

	}

}
