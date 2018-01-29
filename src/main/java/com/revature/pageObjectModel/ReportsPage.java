package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportsPage {

	public static WebElement logout(WebDriver wd) {
		return wd.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button"));
	}
	
	public static void navigateToReportsPage(WebDriver wd) {
		try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")).click();
	}
	
	// Batch Projection
	public static WebElement batchProjectionToolbar(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-card[1]/get-batch-gen-table-toolbar/md-toolbar"));
	}
	
	public static WebElement addNewCardButton(WebDriver wd) {
		return wd.findElement(By.cssSelector("[md-svg-icon*='img/ic_add_circle_white_24px.svg']"));
	}
	
	public static WebElement batchArrowButton(WebDriver wd) {
		return wd.findElement(By.id("batchArrow"));
	}
	
	// Graduate Summary
	public static WebElement gradToolbar(WebDriver wd) {
		return wd.findElement(By.cssSelector("[ng-click*='rCtrl.toggleGradToolbar()']"));
	}
	
	public static WebElement exportToCSV1(WebDriver wd) {
		return wd.findElement(By.cssSelector("[ng-csv*='rCtrl.export()']"));
	}
	
	public static WebElement gradArrowButton(WebDriver wd) {
		return wd.findElement(By.id("gradArrow"));
	}

	// not found
	public static WebElement gradSettingsButton(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-card[2]/get-train-table-toolbar/md-toolbar/md-menu/button"));
	}
	
	// Incoming Trainee Summary
	public static WebElement incomingTraineeToolbar(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-card[3]/get-train-table-toolbar/md-toolbar"));
	}
	
	public static WebElement exportToCSV2(WebDriver wd) {
		return wd.findElement(By.cssSelector("[ng-csv*='rCtrl.export2()']"));
	}
	
	public static WebElement incArrowButton(WebDriver wd) {
		return wd.findElement(By.id("incArrow"));
	}
	
	// not found
	public static WebElement traineeSettingsButton(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-card[3]/get-train-table-toolbar/md-toolbar/md-menu/button"));
	}
	
}
