package com.codexan.seleniumtutorial.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

	WebDriver driver;

	By username = By.id("email");
	By password = By.id("passwd");
	By login = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public void enterUserNameAndPassword(String strusername, String strpassword) {
		driver.findElement(username).sendKeys(strusername);
		driver.findElement(password).sendKeys(strpassword);
	}

	public MyAccountPage clickLoginButton() {
		driver.findElement(login).click();
		return new MyAccountPage(driver);
	}

	public String getHeaderText() {
		String headerText = driver.findElement(By.id("center_column").tagName("h1")).getText();
		return headerText;
	}
	
	public LoginPage clickLoginButtonThatWillFail() {
		driver.findElement(login).click();
		return new LoginPage(driver); 
		
	}
	
	public String getErrorHeader() {
		WebElement errorSection = driver.findElement(By.className("alert-danger"));
		WebElement errorHeading = errorSection.findElement(By.tagName("p"));
		return errorHeading.getText();
	}
	
	public List<WebElement> getErrorList() {
		WebElement errorSection = driver.findElement(By.className("alert-danger"));
		WebElement errorList = errorSection.findElement(By.tagName("ol"));
	  return errorList.findElements(By.tagName("li"));
	}

}
