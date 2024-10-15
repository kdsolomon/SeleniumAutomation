package com.learn.section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowScrolling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
	    List<WebElement> values=	driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	    int sum=0;
		for (int i=0;i<values.size();i++) {
	    sum=sum+Integer.parseInt(values.get(i).getText());
 		}
		System.out.println(sum);
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
		List <WebElement>courseFees=driver.findElements(By.cssSelector("[name=\"courses\"] td:nth-child(3)"));
		int sum1=0;
		for (int i=0;i<courseFees.size();i++) {
			sum1=sum1+Integer.parseInt(courseFees.get(i).getText());
	 		}
		System.out.println(sum1);
		
	}

}
