package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BatchPage {
	static WebElement we;
	
//	core curriculum field //*[@id="select_268"]
//	focus field 		  //*[@id="select_270"]
//	Skills field 		  //*[@id="select_272"]
//	Start date field 	  //*[@id="input_275"]
//	End date field 		  //*[@id="input_277"]
//	Week span field 	  //*[@id="input_278"]
//	Name field 			  //*[@id="input_279"]
//	Trainer field 		  //*[@id="select_280"]
//	Co-trainer field 	  //*[@id="select_282"]
//	location field 		  //*[@id="select_284"]
//	building field 		  //*[@id="select_286"]
//	Room field 			  //*[@id="select_288"]
	
	public static WebElement getBatchCurriculumInput(WebDriver wd) {
		return wd.findElement(By.id("select_268"));
	}
	
	public static WebElement getBatchFocusInput(WebDriver wd) {
		return wd.findElement(By.id("select_270"));
	}
	
	public static WebElement getBatchSkillsInput(WebDriver wd) {
		return wd.findElement(By.id("select_272"));
	}
	
	public static WebElement getBatchStartDateInput(WebDriver wd) {
		return wd.findElement(By.id("input_275"));
	}
	
	public static WebElement getBatchEndDateInput(WebDriver wd) {
		return wd.findElement(By.id("input_277"));
	}
	
	public static WebElement getBatchWeekSpanInput(WebDriver wd) {
		return wd.findElement(By.id("input_278"));
	}
	
	public static WebElement getBatchNameInput(WebDriver wd) {
		return wd.findElement(By.id("input_279"));
	}
	
	public static WebElement getBatchTrainerInput(WebDriver wd) {
		return wd.findElement(By.id("select_280"));
	}
	
	public static WebElement getBatchCoTrainerInput(WebDriver wd) {
		return wd.findElement(By.id("select_282"));
	}
	
	public static WebElement getBatchLocationInput(WebDriver wd) {
		return wd.findElement(By.id("select_284"));
	}
	
	public static WebElement getBatchBuildingInput(WebDriver wd) {
		return wd.findElement(By.id("select_286"));
	}
	
	public static WebElement getBatchRoomInput(WebDriver wd) {
		return wd.findElement(By.id("select_288"));
	}
	
	public static WebElement getBatchSubmitBtn(WebDriver wd) {
		return wd.findElement(By.id(""));
	}
}
