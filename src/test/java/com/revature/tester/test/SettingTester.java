package com.revature.tester.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.SettingsPage;

public class SettingTester {

	WebDriver wd = DriverFactory.getDriver("chrome");
	
	@Test(groups = "VP")
	public void testSettingsPageAsVP() {
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("99");
		
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("99");
		
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("99");
		
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("99");
		
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("99");
		
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
		
//		SettingsPage.defaultBuilding(wd).sendKeys();		// Default Building field doesn't update until you save the default location AND refresh the page...
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("99");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("99");
		
		SettingsPage.findSaveButton(wd).click();			// only available as VP
	}
	
	@Test(groups = "Trainer")
	public void testSettingsPageAsTrainer() {
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("99");
		
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("99");
		
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("99");
		
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("99");
		
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("99");
		
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("99");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("99");
	}
	
}
