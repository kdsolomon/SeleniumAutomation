package Selenium.Learning;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class App2 
{

	@Test
	public  void test1( ) throws AWTException, InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.cssSelector("[autocapitalize=\"none\"]")).sendKeys("LearnSelenium");
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		int size=-driver.findElements(By.xpath("//*[contains(text(), 'Selenium')]")).size();
		System.out.println(size);
		driver.quit();

	}
}
