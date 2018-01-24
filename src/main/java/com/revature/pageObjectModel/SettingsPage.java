package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage {
	
	public static WebElement timelineTrainersPerPage(WebDriver wd) {
		return wd.findElement(By.id("input_3"));
	}
	
	public static WebElement reportsOutgoingGrads(WebDriver wd) {
		return wd.findElement(By.id("input_4"));
	}
	
	public static WebElement reportsIncomingCandidates(WebDriver wd) {
		return wd.findElement(By.id("input_5"));
	}
	
	// Drop Down Menu
	public static WebElement defaultLocation(WebDriver wd) {
		return wd.findElement(By.id("select_6"));
	}

	// Drop Down Menu
	public static WebElement defaultBuilding(WebDriver wd) {
		return wd.findElement(By.id("select_7"));
	}
	
	public static WebElement minBatchSize(WebDriver wd) {
		return wd.findElement(By.id("input_10"));
	}
	
	public static WebElement maxBatchSize(WebDriver wd) {
		return wd.findElement(By.id("input_11"));
	}
	
	public static WebElement defaultBatchLength(WebDriver wd) {
		return wd.findElement(By.id("input_12"));
	}
	
	public static WebElement minBetweenTrainerBatch(WebDriver wd) {
		return wd.findElement(By.id("input_13"));
	}
}
