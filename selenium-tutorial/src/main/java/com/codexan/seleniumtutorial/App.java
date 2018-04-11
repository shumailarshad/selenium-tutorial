package com.codexan.seleniumtutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
       	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\New folder\\Lib\\chromedriver\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://automationpractice.com/index.php"); 
    	driver.close();
    	
    }
}
