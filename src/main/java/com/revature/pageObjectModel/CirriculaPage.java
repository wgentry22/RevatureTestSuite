package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class CirriculaPage {

	public static WebElement e = null;
	
	
	public static final String salesforceURL = "https://dev.assignforce.revaturelabs.com";
	public static final String vpUsername = "test.vpoftech@revature.com.int1";
	public static final String vpPassword = "p@$$w0rd1";
	public static final String trainerUsername = "test.trainer@revature.com.int1";
	public static final String trainerPassword = "p@$$w0rd2";
	
	
	public static void openSalesforceChrome(WebDriver driver) {
		driver.get(salesforceURL);
	}
	
	public static void openSalesforceFirefox(WebDriver driver) {
		driver.get(salesforceURL);
	}
	
	
	public static void authenticate(WebDriver driver) {
		driver.findElement(By.id("emc")).sendKeys("19655");
		driver.findElement(By.id("save")).click();
	}
	
	
	
	public static void loginVPCredentials(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(vpUsername);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(vpPassword);
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
	}
	
	public static void loginTrainerCredentials(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(trainerUsername);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(trainerPassword);
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
	}
	
	public static WebElement overviewTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//*[@href=\"home\"]"));
		return e;
	}
	
	public static WebElement batchesTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//a[@href=\"batches\"]"));
		return e;
	}
	
	public static WebElement locationsTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//a[@href=\"locations\"]"));
		return e;
	}
	
//	/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]
	public static WebElement curriculaTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//a[@href=\"curriculum\"]/"));
		return e;
	}
	
	public static WebElement trainersTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//a[@href=\"trainers\"]"));
		return e;
	}
	
	public static WebElement reportsTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//a[@href=\"reports\"]"));
		return e;
	}
	
	public static WebElement settingsTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//a[@href=\"settings\"]"));
		return e;
	}
	
	public static WebElement logoutTab(WebDriver driver) {
		e = driver.findElement(By.xpath("//button[contains(text(), 'Logout']"));
		return e;
	}
	
	
	
}
