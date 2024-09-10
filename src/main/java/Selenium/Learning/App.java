package Selenium.Learning;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class App 
{
	public static void main( String[] args ) throws AWTException, InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		System.out.println( "Hello World!" );

		boolean text=driver.getPageSource().contains("Selenium");
		if(text) {
			System.out.println("text is present");
		}
		else {
			System.out.println("text not present");
		}
		driver.findElement(By.cssSelector("[autocapitalize=\"none\"]")).sendKeys("LearnSelenium");
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		int size=-driver.findElements(By.xpath("//*[contains(text(), 'Selenium')]")).size();
		System.out.println(size);

		driver.quit();

	}
}
