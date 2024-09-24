package com.learn.Section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frameTEst {
	

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.cssSelector("[class='demo-frame']")));
		System.out.println("Element clicked");
		Actions act=new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target =driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).build().perform();
		System.out.println("Element dragged and dropped");
		driver.switchTo().defaultContent();
	}

}
