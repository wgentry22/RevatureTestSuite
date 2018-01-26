package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.OverviewPage;

public class OverviewTester {
	static WebDriver wd = DriverFactory.getDriver("chrome");
	static Properties props;
	
	@BeforeClass
	public static void doLogin() {
		wd.get("http://dev.assignforce.revaturelabs.com/");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");
	}
	
	@AfterClass
	public static void doLogout() {
		wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button")).click();
	}
	
	@Test(groups= {"VP","Trainer"},priority=1)
	public static void testCSVDownload() {
		// navigate to correct page
		// wd.get("https://dev.assignforce.revaturelabs.com/home");
		// download csv file
		OverviewPage.getExportToCSVBtn(wd).click();
	}
	
	@Test(groups= {"VP","Trainer"},priority=2)
	public static void testFilter() {
		for (int i=1;i<=3;i++) {
			// click filter button
			OverviewPage.getFilterBtn(wd).click();
			// click each filter option button
			OverviewPage.getFilterDropdownBtn(wd, 1);
		}
	}
	
	@Test(groups= {"VP","Trainer"},priority=2)
	public static void testTableSort() {
		for (int i=1;i<=8;i++) {// for each column...
			// Sort ascending
			OverviewPage.getColumnSortBtn(wd, i).click();
			// Sort descending
			OverviewPage.getColumnSortBtn(wd, i).click();
		}
	}
}
