package com.learn.section13;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCheck {
	
	public static void main(String[] args) throws IOException {
		
		//chromedriver.chromium.org/capabilities
		
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
	//	options.setExperimentalOption("excludesSwitches",Arrays.asList("disable-popup-blocking"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\ksolomon\\screenshots"));
		
	}

}
