package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TrainersPage {
	
	public static WebElement selectAddTrainer(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar[1]/div/button[1]"));
	}
	
	public static WebElement selectViewPTOCalendar(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar[1]/div/button[2]"));
	}
	
	public static WebElement selectDownloadResume(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div/div[1]/button[1]"));
	}

	public static WebElement selectDeactivateTrainer(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div/div[1]/button[2]"));
	}
	
	public static WebElement selectReactivateTrainer(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[2]/md-list/md-list-item/button"));
	}
	
	public static WebElement selectSaveNewTrainer(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]"));
	}
	
	public static WebElement selectCancelAddTrainer(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[2]"));
	}
	
	public static WebElement insertTrainerFirstname(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"input_208\"]"));
	}
	
	public static WebElement insertTrainerLastname(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"input_209\"]"));
	}
	
	public static WebElement selectMoveBackInCalendar(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"navBack1\"]"));
	}
	
	public static WebElement selectMoveForwardInCalendar(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"navForward1\"]"));
	}
	
	public static WebElement selectCalendarWeekView(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"calendarTabs1\"]/table/tbody/tr/td[1]/div[3]"));
	}
	
	public static WebElement selectCalendarMonthView(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"calendarTabs1\"]/table/tbody/tr/td[2]/div[3]"));
	}
	
	public static WebElement selectAddToCalandar(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"footer1\"]/tbody/tr/td[2]/div"));
	}
	
	public static WebElement selectAddPTORequest(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"dialogContent_241\"]/md-dialog-actions/button[1]"));
	}
	
	public static WebElement selectCancelCalendar(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"dialogContent_241\"]/md-dialog-actions/button[2]"));
	}
	
	public static WebElement insertPTOStartDate(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"input_243\"]"));
	}
	
	public static WebElement insertPTOEndDate(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"input_245\"]"));
	}
	
	public static WebElement selectSendPTORequest(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]"));
	}
	
	public static WebElement selectCancelPTORequest(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[2]"));
	}
	
	public static WebElement selectStartDateDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"dialogContent_246\"]/div/md-input-container[1]/md-datepicker/div/button"));
	}
	
	public static WebElement selectEndDateDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"dialogContent_246\"]/div/md-input-container[2]/md-datepicker/div/button"));
	}
	
	public static WebElement selectTodayOnCalendar(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"todayButton1\"]"));
	}
	
	public static WebElement selectCalanderList(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"calendarListButton1\"]"));
	}
	
	public static WebElement selectCalanderMonthDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"dateEditableBox1\"]"));
	}
	
	
}