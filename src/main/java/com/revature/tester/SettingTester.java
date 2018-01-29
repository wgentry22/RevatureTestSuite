package com.revature.tester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.SettingsPage;
import com.revature.tester.MethodUtil;

public class SettingTester {											// TestNG Framework

	static WebDriver wd = null;

	public static String input1 = null;
	public static String input2 = null; 
	public static String input3 = null;
	public static String input4 = null;
	public static String input5 = null;
	public static String locationInSettings = null;
	public static String input6 = null;
	public static String input7 = null;
	
	public static String locationInBatch = null;
	
	@BeforeGroups(enabled = true, groups = {"VP", "checkChanges"})
	public static void loginAsVP() {
		System.out.println("BeforeTest - VP");
		wd = DriverFactory.getDriver("chrome");
		
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");
	}
	
	@BeforeGroups(enabled = true, groups = "Trainer")
	public static void loginAsTrainer() {
		System.out.println("BeforeTest - Trainer");
		wd = DriverFactory.getDriver("chrome");
		
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");
	}
	
	@AfterGroups(enabled = true, groups = {"VP", "Trainer"})
	public static void logout() {
		LoginPage.logout(wd);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}
	
	// -------- Group Test --------
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public static void testSettingsPageAsVP() {

		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a").click();
		
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields

		input1 = "10";
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys(input1);
		
		input2 = "40";
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys(input2);

		input3 = "30";
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys(input3);

		// only works if ONE word
//		locationInSettings = "New";
		locationInSettings = "Revature";
		SettingsPage.defaultLocation(wd).sendKeys(locationInSettings);

		input4 = "20";
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys(input4);
		
		input5 = "25";
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys(input5);
		
		input6 = "23";
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys(input6);
		
		input7 = "14";
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys(input7);

//		// ----- saving the changes -----
		SettingsPage.findSaveButton(wd).click();			// only available as VP
		
//		LoginPage.logout(wd);
//		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wd.quit();
	}
	
	// -------- Tests to make sure changes were saved --------
	@Test(enabled = true, groups = "VP", priority = 1)
	public static void testDefaultLocation() {

		System.out.println("--- locationInSettings: " + locationInSettings);
		
		// Navigating to the Batch Page
		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a").click();
		try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }			// timer for page to fully load

		locationInBatch = wd.findElement(By.cssSelector("[ng-model='bCtrl.batch.location']")).getText();
		System.out.println("testDefaultLocation - locationInBatch: " + locationInBatch);
		
		if(locationInSettings != null && locationInBatch != null) {
			if(locationInBatch.toLowerCase().contains(locationInSettings.toLowerCase())) {
				System.out.println("You Win!!");
			} else {
				System.out.println("You Failed!! Try Again!");
			}
		}
	}
	
	@Test(enabled = true, groups = "VP", priority = 2)
	public static void testTimelineTrainersPerPage() {
		
		System.out.println("input1:" + input1);
		
		// don't need to navigate to batches page because you're already there

		locationInBatch = wd.findElement(By.cssSelector("[ng-model='pagination.perPage']")).getText();
		System.out.println("testTimelineTrainersPerPage - locationInBatch: " + locationInBatch);
		
		if(locationInBatch.toLowerCase().contains(input1.toLowerCase())) {
			System.out.println("You Win!!");
		} else {
			System.out.println("You Failed!! Try Again!");
		}
	}
	
	@Test(enabled = true, groups = "Trainer", priority = 3)
	public static void testOutgoingGrads() {
		
		System.out.println("input2: " + input2);

		// Navigating to the Reports Page
		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a").click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }			// timer for page to fully load
		
		locationInBatch = wd.findElement(By.cssSelector("[ng-model*='rCtrl.graduates']")).getText();
		System.out.println("testOutgoingGrads - locationInBatch: " + locationInBatch);
		
		if(locationInBatch.toLowerCase().contains(input2.toLowerCase())) {
			System.out.println("You Win!!");
		} else {
			System.out.println("You Failed!! Try Again!");
		}
	}
	
	@Test(enabled = true, groups = "Trainer", priority = 4)
	public static void testIncomingTrainees() {
		
		System.out.println("input3: " + input3);

		// don't need to navigate to reports page because you're already there		
		
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='rCtrl.incoming']")).getText();
		System.out.println("locationInBatch: " + locationInBatch);
		
		if(locationInBatch.toLowerCase().contains(input3.toLowerCase())) {
			System.out.println("You Win!!");
		} else {
			System.out.println("You Failed!! Try Again!");
		}
	}
	
	// ----- Testing Settings Page As A Trainer -----
	@Test(enabled = true, groups = "Trainer", priority = 5)
	public static void testSettingsPageAsTrainer() {

		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a").click();
		
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields
		
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys("30");
		
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys("30");
		
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys("30");
		
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys("30");
		
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys("30");
		
		String newLocation = "Revature";
		String newLocation2 = "New York City";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation2);
		
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("30");
		
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("30");
	}
	
}
