package com.learn.Section8;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	@Test	
	public  void test1() throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//expected Array
		String [] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Carrot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
//        WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"promoBtn\"]")));
		driver.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button ")).click();
		
		
	}
	
	
	
	
	
	
	
	
	public static void addItems(WebDriver driver,String [] itemsNeeded) {
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
		driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
		if(j==itemsNeeded.length) {
			break;
		}
		}
		System.out.println("Cart Added is "+i);
		}
	}
	
	public void fluentWait(WebDriver driver) {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id= 'start'] button")).click();
		Wait<WebDriver>wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement foo= wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("[id='finish] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish] h4"));
				}
				else {
				return null;
				}
			}
		});
		System.out.println(driver.findElement(By.cssSelector("[id='finish] h4")).getText());
	}
}



//Amazon Interview question how to add items to cart from array 
