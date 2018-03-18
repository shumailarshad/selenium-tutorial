package com.codexan.seleniumtutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage clickSignInButton() {
		driver.findElement(By.className("login")).click();
		return new LoginPage(driver);
	}

}
