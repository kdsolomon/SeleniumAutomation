package com.learn.Section8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	@Test	
	public  void test1() throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//expected Array
		String [] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0;i<products.size();i++) {
		//Cauliflower - 1 Kg
		String[] name=products.get(i).getText().split("-");
		String formattedName=name[0].trim();
		//format name to get actual vegetable easy search 
		
		//check if name extracted is present in array of nor
		
		//convert array to arraylist for easy search
		List<String> itemsNeededList=Arrays.asList(itemsNeeded);
		if(itemsNeededList.contains(formattedName)) {
		j++;
			//Click on AddToChart
		driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
		if(j==3) {
			break;
		}
		}
		}
	driver.close();	
	}
}
