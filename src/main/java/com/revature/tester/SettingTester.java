package com.revature.tester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.SettingsPage;

public class SettingTester {											// TestNG Framework

	static WebDriver wd = DriverFactory.getDriver("chrome");
	
	@BeforeSuite(enabled = false, groups = "VP")
	private static void loginAsVP() {									// don't need if we driver is already open
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");
	}
	
	@BeforeSuite(enabled = true, groups = "Trainer")
	private static void loginAsTrainer() {								// don't need if we driver is already open
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");
	}
	
	@BeforeTest(enabled = true)
	public static void navigateToSettinsPage() {
		SettingsPage.navigateToSettingsPage(wd);
	}
	
	@Test(enabled = false, groups = "VP")
	public static void testSettingsPageAsVP() {
		
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields
		
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("10");
		
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("10");
		
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("10");
		
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("10");
		
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("10");
		
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
		
//		SettingsPage.defaultBuilding(wd).sendKeys();		// Default Building field doesn't update until you save the default location AND refresh the page...
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("10");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("10");
		
		// ----- saving the changes : only available as VP -----
//		SettingsPage.findSaveButton(wd).click();
	}
	
	@Test(enabled = true, groups = "Trainer")
	public static void testSettingsPageAsTrainer() {
		
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields
		
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("20");
		
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("20");
		
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("20");
		
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("20");
		
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("20");
		
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("20");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("20");
	}
	
}
