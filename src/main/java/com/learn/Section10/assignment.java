package com.learn.Section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		System.out.println("Element switched");
		String text=driver.findElement(By.cssSelector("[name=\"frame-middle\"]")).getText();
		int size =driver.switchTo().frame(0).findElements(By.tagName("frame")).size();
		System.out.println(size);
		System.out.println(text);
		
		
		}

}
