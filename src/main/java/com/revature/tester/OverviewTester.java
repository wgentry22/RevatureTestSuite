package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.OverviewPage;

public class OverviewTester {
	static WebDriver wd = DriverFactory.getDriver("chrome");
	static Properties props = new Properties();
	
	@BeforeClass
	public static void doLogin() {
		MethodUtil.loadPropertiesFile(props);
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("TrainerUsername"), props.getProperty("TrainerPassword"));
	}
	
	@AfterClass
	public static void doLogout() {
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "(//button)[1]"));
	}
	
	@AfterSuite
	public static void closeDriver() {
		MethodUtil.waitAndQuitDriver(wd,Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	
	@Test(groups= {"VP","Trainer"},priority=1)
	public static void testCSVDownload() {
		// navigate to correct page
		wd.get("https://dev.assignforce.revaturelabs.com/home");
		// download csv file
		OverviewPage.getExportToCSVBtn(wd).click();
	}
	
	@Test(groups= {"VP","Trainer"},priority=2)
	public static void testFilter() {
		for (int i=1;i<=3;i++) {
			// click filter button
			MethodUtil.executeJSClick(wd, OverviewPage.getFilterBtn(wd));
			// click each filter option button
			MethodUtil.executeJSClick(wd, OverviewPage.getFilterDropdownBtn(wd, 1));
		}
	}
	
	@Test(groups= {"VP","Trainer"},priority=3,enabled=false)
	public static void testTableSort() {
		for (int i=1;i<=8;i++) {// for each column...
			// Sort ascending
			MethodUtil.executeJSClick(wd, OverviewPage.getColumnSortBtn(wd, i));
			// Sort descending
			MethodUtil.executeJSClick(wd, OverviewPage.getColumnSortBtn(wd, i));
		}
	}
}
