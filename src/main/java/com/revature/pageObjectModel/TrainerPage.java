package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.tester.MethodUtil;
public class TrainerPage {
	static MethodUtil waiting = new MethodUtil();
	
	public static WebElement selectTrainersTab(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar[1]/div/button[1]"));
		return waiting.waitForLoad(wd, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]/a");
	}
	public static WebElement selectAddTrainer(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar[1]/div/button[1]"));
		return waiting.waitForLoad(wd, "//*[@id=\"view\"]/md-card/md-toolbar[1]/div/button[1]");
	}
	
	public static WebElement selectViewPTOCalendar(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar[1]/div/button[2]"));
		return waiting.waitForLoad(wd, "//*[@id=\"view\"]/md-card/md-toolbar[1]/div/button[2]");
	}
	
	public static WebElement selectDownloadResume(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div/div[1]/button[1]"));
		return waiting.waitForLoad(wd, "//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div/div[1]/button[1]");
	}

	public static WebElement selectDeactivateTrainer(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div/div[1]/button[2]"));
		return waiting.waitForLoad(wd, "//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div/div[1]/button[2]");
	}
	
	public static WebElement selectReactivateTrainer(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[2]/md-list/md-list-item/button"));
		return waiting.waitForLoad(wd, "//*[@id=\"view\"]/md-card/md-content[2]/md-list/md-list-item/button");
	}
	
	public static WebElement selectSaveNewTrainer(WebDriver wd) {
		//return wd.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]"));
		return waiting.waitForLoad(wd, "/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]");
		
	}
	
	public static WebElement selectCancelAddTrainer(WebDriver wd) {
		//return wd.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[2]"));
		return waiting.waitForLoad(wd, "/html/body/div[3]/md-dialog/form/md-dialog-actions/button[2]");
	}
	
	public static WebElement insertTrainerFirstname(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"input_208\"]"));
		return waiting.waitForLoad(wd, "//*[@id=\"input_1\"]");
	}
	
	public static WebElement insertTrainerLastname(WebDriver wd) {
		//return wd.findElement(By.xpath("//*[@id=\"input_209\"]"));
		return waiting.waitForLoad(wd, "//*[@id=\"input_2\"]");
	}
	
	public static WebElement selectMoveBackInCalendar(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"navBack1\"]"));
	}
	
	public static WebElement selectMoveForwardInCalendar(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"navForward1\"]"));
	}
	
	public static WebElement selectCalendarWeekView(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"calendarTabs1\"]/table/tbody/tr/td[1]/div[3]"));
	}
	
	public static WebElement selectCalendarMonthView(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"calendarTabs1\"]/table/tbody/tr/td[2]/div[3]"));
	}
	
	public static WebElement selectAddToCalandar(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"footer1\"]/tbody/tr/td[2]/div"));
	}
	
	public static WebElement selectAddPTORequest(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"dialogContent_241\"]/md-dialog-actions/button[1]"));
	}
	
	public static WebElement selectCancelCalendar(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"dialogContent_241\"]/md-dialog-actions/button[2]"));
	}
	
	public static WebElement insertPTOStartDate(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"input_243\"]"));
	}
	
	public static WebElement insertPTOEndDate(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"input_245\"]"));
	}
	
	public static WebElement selectSendPTORequest(WebDriver wd) {
		return wd.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]"));
	}
	
	public static WebElement selectCancelPTORequest(WebDriver wd) {
		return wd.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[2]"));
	}
	
	public static WebElement selectStartDateDropdown(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"dialogContent_246\"]/div/md-input-container[1]/md-datepicker/div/button"));
	}
	
	public static WebElement selectEndDateDropdown(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"dialogContent_246\"]/div/md-input-container[2]/md-datepicker/div/button"));
	}
	
	public static WebElement selectTodayOnCalendar(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"todayButton1\"]"));
	}
	
	public static WebElement selectCalanderList(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"calendarListButton1\"]"));
	}
	
	public static WebElement selectCalanderMonthDropdown(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"dateEditableBox1\"]"));
	}
	
	
}