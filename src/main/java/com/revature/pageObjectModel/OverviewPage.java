package com.revature.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.tester.MethodUtil;

public class OverviewPage {
	
	public static WebElement getExportToCSVBtn(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-toolbar/div[1]/button"));
	}
	
	public static WebElement getFilterBtn(WebDriver wd) {
		return wd.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-toolbar/md-menu/button"));
	}
	
	public static WebElement getFilterDropdownBtn(WebDriver wd,int index) {
		// return wd.findElement(By.xpath("//*[@id=\"menu_container_0\"]/md-menu-content/md-menu-item["+index+"]/button"));
		//return wd.findElement(By.cssSelector("#menu_container_0 > md-menu-content > md-menu-item:nth-child("+index+") > button"));
		return (new MethodUtil()).waitForLoad(wd, "//*[@id=\"menu_container_0\"]/md-menu-content/md-menu-item["+index+"]/button");
	}
	
	public static WebElement getColumnSortBtn(WebDriver wd,int index) {
		return wd.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th["+index+"]/md-icon"));
	}
}
