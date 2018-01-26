package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static WebElement getUsernameInput(WebDriver wd) {
		return wd.findElement(By.id("username"));
	}
	
	public static WebElement getPasswordInput(WebDriver wd) {
		return wd.findElement(By.id("password"));
	}
	
	public static WebElement getLoginBtn(WebDriver wd) {
		return wd.findElement(By.id("Login"));
	}
	
	public static void loginAs(WebDriver wd,String username,String password) {
		wd.manage().window().maximize();
		getUsernameInput(wd).sendKeys(username);
		getPasswordInput(wd).sendKeys(password);
		getLoginBtn(wd).click();
	}
}
