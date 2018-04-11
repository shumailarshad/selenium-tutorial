package com.codexan.seleniumtutorial.sections;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ErrorSection {
	
	private WebElement element;
	
	public ErrorSection(WebElement element) {
		this.element = element;
	}
	
	public String getErrorHeader() {
		WebElement errorHeading = element.findElement(By.tagName("p"));
		return errorHeading.getText();
	}
	
	public List<String> getErrorList() {
		WebElement errorElementList = element.findElement(By.tagName("ol"));
		List<WebElement> errorListItems = errorElementList.findElements(By.tagName("li"));
		
		List<String> errors = new ArrayList();
		for(WebElement each : errorListItems) {
			errors.add(each.getText());			
		}
		
		return errors; 
	}

}
