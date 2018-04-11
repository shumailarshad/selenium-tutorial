package com.codexan.seleniumtutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {		
		this.driver = driver;
	}
	
	public WebElement getLogoutButton() {
		return driver.findElement(By.className("logout"));
	}
	
	public LoginPage clickSignOutButton() {
		getLogoutButton().click();
		return new LoginPage(driver);		
	}
	
	public TshirtsPage clickOnTshirts(){
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();
		return new TshirtsPage(driver);
		}
}

