package com.revature.tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static com.revature.driver.DriverFactory.*;
import static com.revature.pageObjectModel.TrainersPage.*;

public class TrainerTester {

	static WebDriver wd = getDriver("firefox");
	
	public static void main(String[] args) {
		wd.get("https://dev.assignforce.revaturelabs.com");
		login();
	}
	
	static void login() {
		wd.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("test.vpoftech@revature.com.int1");
		wd.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("p@$$w0rd1");
		wd.findElement(By.xpath("//*[@id=\"Login\"]")).submit();
		wd.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]/a")).click();
		selectAddTrainer(wd);
		selectCancelAddTrainer(wd);
		selectViewPTOCalendar(wd);
		
	}
}
