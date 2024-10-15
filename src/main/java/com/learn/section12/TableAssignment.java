package com.learn.section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableAssignment {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(5000);
		List<WebElement> values=driver.findElements(By.cssSelector("[name=\"courses\"] th"));
		List <WebElement>courseFees=driver.findElements(By.cssSelector("[name=\"courses\"] td:nth-child(3)"));
		List<WebElement> rows =driver.findElements(By.cssSelector("[name=\"courses\"] tr"));
		System.out.println("No of the columns in the table is  "+ values.size()+" and length of the rows is "+courseFees.size());
		String row2="";
		for(int i=0;i<rows.size();i++) {
			if(i==2) {
		 row2=rows.get(i).getText();
			}	
		}
		System.out.println("The second row is "+row2);   
	}

}
