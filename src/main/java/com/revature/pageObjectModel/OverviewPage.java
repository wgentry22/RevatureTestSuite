package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {
	
	public static WebElement getOverviewField(WebDriver wd) {
		return wd.findElement(By.id(""));
	}
}
