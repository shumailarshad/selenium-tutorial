package com.codexan.seleniumtutorial.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtsPage {
	
		WebDriver driver;

		public TshirtsPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void clickTshirt() {			
			driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li/a[@title='T-shirts']")).click();
		}
		
		public void clickOnTheimage() {
			driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")).click();
		}
		
		public int numberOfFrames() {
		int size = driver.findElements(By.tagName("iframe")).size();
		return size;
		}
		
		public void clickOnAddToCartButton() {
			//driver.switchTo().frame(0);
			//driver.switchTo().frame("fancybox-frame1523477718421");
			//driver.findElement(By.xpath("//p[@id='add_to_cart']/button")).click();
			driver.findElement(By.id("add_to_cart")).click();
			//driver.switchTo().defaultContent();
			
		}
		
							
}

