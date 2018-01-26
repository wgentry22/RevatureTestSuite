package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BatchPage {
	static WebElement we;
	
//	core curriculum field 
//	focus field 		  
//	Skills field 		  
//	Start date field 	  
//	End date field 		  
//	Week span field 	  
//	Name field 			  
//	Trainer field 		  
//	Co-trainer field 	  
//	location field 		  
//	building field 		  
//	Room field 			  
	
	public static WebElement getSelectMenuOption(WebDriver wd,int selectMenuNum,int optionNum) {
		return wd.findElement(By.xpath("(//md-select-menu)["+selectMenuNum+"]/md-option["+optionNum+"]"));
	}
	
	public static WebElement getBatchCurriculumSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[1]"));		
	}
	
		public static WebElement getBatchCurriculumOption(WebDriver wd) {
			return getSelectMenuOption(wd, 10, 1);
		}
	
	public static WebElement getBatchFocusSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[2]"));
	}
	
		public static WebElement getBatchFocusOption(WebDriver wd) {
			return getSelectMenuOption(wd, 11, 1);
		}
	
	public static WebElement getBatchSkillsSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[3]"));
	}
	
		public static WebElement getBatchSkillsOption(WebDriver wd) {
			return getSelectMenuOption(wd, 12, 1);
		}
	
	public static WebElement getBatchStartDateInput(WebDriver wd) {
		return wd.findElement(By.xpath("(//input)[1]"));
	}
	
	public static WebElement getBatchEndDateInput(WebDriver wd) {
		return wd.findElement(By.xpath("(//input)[2]"));
	}
	
	public static WebElement getBatchWeekSpanInput(WebDriver wd) {
		// NOTE: this input is read-only
		return wd.findElement(By.xpath("(//input)[3]"));
	}
	
	public static WebElement getBatchNameInput(WebDriver wd) {
		return wd.findElement(By.xpath("(//input)[4]"));
	}
	
	public static WebElement getBatchTrainerSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[4]"));
	}
	
		public static WebElement getBatchTrainerOption(WebDriver wd) {
			return getSelectMenuOption(wd, 1, 1);
		}
	
	public static WebElement getBatchCoTrainerSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[5]"));
	}
		public static WebElement getBatchCoTrainerOption(WebDriver wd) {
			return getSelectMenuOption(wd, 2, 1);
		}
	
	public static WebElement getBatchLocationSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[6]"));
	}
		public static WebElement getBatchLocationOption(WebDriver wd) {
			return getSelectMenuOption(wd, 3, 1);
		}
	
	public static WebElement getBatchBuildingSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[7]"));
	}
		public static WebElement getBatchBuildingOption(WebDriver wd) {
			return getSelectMenuOption(wd, 4, 1);
		}
	
	public static WebElement getBatchRoomSelect(WebDriver wd) {
		return wd.findElement(By.xpath("(//md-select)[8]"));
	}
		public static WebElement getBatchRoomOption(WebDriver wd) {
			return getSelectMenuOption(wd, 5, 1);
		}
	
	public static WebElement getBatchSubmitBtn(WebDriver wd) {
		return wd.findElement(By.xpath("(//button)[2]"));
		//*[@id="view"]/md-card/md-content[1]/form/md-toolbar/button[1]
	}
	
	public static WebElement getBatchCancelBtn(WebDriver wd) {
		return wd.findElement(By.xpath("(//button)[3]"));
	}
}
