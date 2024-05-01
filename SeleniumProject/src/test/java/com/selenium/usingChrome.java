package com.selenium;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class usingChrome {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://letcode.in/shadow");
	        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	        driver.findElement(By.id("fname")).sendKeys("Anand");
	        Thread.sleep(1000);
	        driver.quit();
	}

}
