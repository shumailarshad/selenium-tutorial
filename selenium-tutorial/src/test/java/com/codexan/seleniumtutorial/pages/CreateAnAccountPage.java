package com.codexan.seleniumtutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {

	WebDriver driver;

	public CreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		driver.findElement(By.id("id_gender1")).click();

	}

	public void enterFirstName(String strFirstName) {
		driver.findElement(By.id("customer_firstname")).sendKeys(strFirstName);
	}

	public void enterLastName(String strLastname) {
		driver.findElement(By.id("customer_lastname")).sendKeys(strLastname);
	}

	public void enterEmailAddress(String strEmail) {
		driver.findElement(By.id("email")).sendKeys(strEmail);
	}

	public void enterPassword(String strPassword) {
		driver.findElement(By.id("passwd")).sendKeys(strPassword);
	}

	public void enterDateOfBirth(String selectDate, String selectMonth, String selectYear) {
		Select select = new Select(driver.findElement(By.id("days")));
		select.selectByValue(selectDate);
		select = new Select(driver.findElement(By.id("months")));
		select.selectByValue(selectMonth);
		select = new Select(driver.findElement(By.id("years")));
		select.selectByValue(selectYear);
	}

	public void enterAddressFirstname(String strFirstname) {
		driver.findElement(By.id("firstname")).sendKeys(strFirstname);
	}

	public void enterAddressLastname(String strAddressLastname) {
		driver.findElement(By.id("lastname")).sendKeys(strAddressLastname);
	}

	public void enterAddress(String strAddress) {
		driver.findElement(By.id("address1")).sendKeys(strAddress);
	}

	public void enterCity(String strCity) {
		driver.findElement(By.id("city")).sendKeys(strCity);
	}

	public void selectState(String strState) {
		Select select = new Select(driver.findElement(By.id("id_state")));
		select.selectByVisibleText(strState);
	}

	public void enterPostalCode(String strPostcode) {
		driver.findElement(By.id("postcode")).sendKeys(strPostcode);

	}

	public void selectCountry(String strCountry) {
		Select select = new Select(driver.findElement(By.id("id_country")));
		select.selectByVisibleText(strCountry);
	}

	public void enterMobileNumber(String phoneNumber) {
		driver.findElement(By.id("phone")).sendKeys(phoneNumber);

	}

	public void enterAddressAlias(String strAddressAlias) {
		driver.findElement(By.id("alias")).sendKeys(strAddressAlias);

	}

	public void clickRegisterButton() {
		driver.findElement(By.id("submitAccount")).click();

	}
}
