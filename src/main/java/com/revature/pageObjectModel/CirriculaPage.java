package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.tester.MethodUtil;




public class CirriculaPage {

	public static WebElement e = null;
	
	public static MethodUtil util = new MethodUtil();
	
	public static final String salesforceURL = "https://dev.assignforce.revaturelabs.com";
	public static final String vpUsername = "test.vpoftech@revature.com.int1";
	public static final String vpPassword = "yuvi1712";
	public static final String trainerUsername = "test.trainer@revature.com.int1";
	public static final String trainerPassword = "trainer123";
	
	
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
//	/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[1]
	public static WebElement overviewTab(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[1]/a");
		return e;
	}
	
	public static WebElement batchesTab(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a");
		return e;
	}

	public static WebElement locationsTab(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a");
		return e;
	}
	
//	/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]/a
	public static WebElement curriculaTab(WebDriver driver) {
		e = util.waitForLoad(driver, "//li[@name=\"curricula\"][@href=\"curriculum\"]/a[@href=\"curriculum\"]");
		return e;
		
	}
	
	public static WebElement trainersTab(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]/a");
		return e;
	}
	
	public static WebElement reportsTab(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a");
		return e;
	}
	
//	/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]
	public static WebElement settingsTab(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a");
		return e;
	}
	
	public static WebElement logoutTab(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button");
		return e;
	}
	
	
	public static WebElement toggleCoreCurriculaPanel(WebDriver driver) {
		e = util.waitForLoad(driver, "//*[@id=\"coreArrow\"]");
		return e;
	}
	
	//*[@id="view"]/md-card/md-content/md-card[2]/md-toolbar/div/button[2]
	
	public static WebElement toggleFocusPanel(WebDriver driver) {
		e = util.waitForLoad(driver, "//*[@id=\"focusArrow\"]");
		return e;
	}
	
//	//*[@id="core"]/md-list/md-list-item[6]/button[2]
	public static WebElement removeCurriculaButton(WebDriver driver) {
		e = util.waitForLoad(driver, "//*[@id=\"core\"]/md-list/md-list-item[6]/button[2]");
		return e;
	}
	
	
	public static WebElement cancelRemoveCurriculumButton(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div[3]/md-dialog/md-dialog-actions/button[1]");
		return e;
	}
	
	public static WebElement confirmRemoveCurriculumButton(WebDriver driver) {
		e = util.waitForLoad(driver, "/html/body/div[3]/md-dialog/md-dialog-actions/button[2]");
		return e;
	}
	
}
