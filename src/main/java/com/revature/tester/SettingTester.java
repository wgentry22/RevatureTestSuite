package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.SettingsPage;

public class SettingTester {											// TestNG Framework

	WebDriver wd = null;
	Properties props = new Properties();
	WebDriverWait wait = null;
	Actions act = null;

	public String input1 = null;
	public String input2 = null; 
	public String input3 = null;
	public String input4 = null;
	public String input5 = null;
	public String locationInSettings = null;
	public String input6 = null;
	public String input7 = null;
	
	public String locationInBatch = null;
	
	public SettingTester(WebDriver wd2, Properties props2) {
		this.wd = wd2;
		this.props = props2;
	}

	@BeforeGroups(enabled = true, groups = {"VP", "checkChanges"})
	public void loginAsVP() {
		System.out.println("BeforeTest - VP");
		wd = DriverFactory.getDriver("chrome");

		wait = new WebDriverWait(wd, 10);
		act = new Actions(wd);
		
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")));
		wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")).click();
	}
	
	@BeforeGroups(enabled = true, groups = "Trainer")
	public void loginAsTrainer() {
		System.out.println("BeforeTest - Trainer");
		wd = DriverFactory.getDriver("chrome");
		
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");
	}
	
	@AfterGroups(enabled = true, groups = {"VP", "Trainer"})
	public void logout() {
		LoginPage.logout(wd);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}
	
	// -------- Individual Test --------
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testTrainersPerPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.trainersPerPage']")));
		input1 = "10";
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys(input1);
	}
	
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testReportsOutgoingGrads() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.reportGrads']")));
		input2 = "40";
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys(input2);
	}
	
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testReportsIncomingCandidates() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.reportIncomingGrads']")));
		input3 = "35";
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys(input3);
	}
	
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testDefaultLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.defaultLocation']")));
		
		// only works if ONE word
//		locationInSettings = "New";
		locationInSettings = "Revature";
		SettingsPage.defaultLocation(wd).sendKeys(locationInSettings);
		
		try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	// will almost always fail, because you need to reload the page for the buildings for the new location to show up
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testDefaultBuilding() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.defaultBuilding']")));
		
		// only works if ONE word
//		locationInSettings = "Main";
		locationInSettings = "Reston";
		SettingsPage.defaultBuilding(wd).sendKeys(locationInSettings);
	}
	
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testMinBatchSize() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.minBatchSize']")));
		input4 = "22";
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys(input4);
	}
	
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testMaxBatchSize() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.maxBatchSize']")));
		input5 = "25";
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys(input5);
	}
	
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testDefaultBatchLength() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.batchLength']")));
		input6 = "23";
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys(input6);
	}
	
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testMinBetweenTrainerBatch() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.trainerBreakDays']")));
		input7 = "14";
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys(input7);
	}
	
	// --- only available as VP ---
	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testSaveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='sCtrl.updateSettings()']")));
		act.moveToElement(SettingsPage.findSaveButton(wd)).click().build().perform();
	}
	
	// -------- Group Test --------
	@Test(enabled = false, groups = {"VP"}, priority = 0)
	public void testSettingsPageAsVP() {

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
	}
	
	// -------- Tests to make sure changes were saved --------
	@Test(enabled = true, groups = "VP", priority = 2)
	public void testTheDefaultLocation() {

		System.out.println("--- locationInSettings: " + locationInSettings);
		
		// Navigating to the Batch Page
		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a").click();

//		try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }			// timer for page to fully load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bCtrl.batch.location']")));
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
	
	@Test(enabled = true, groups = "VP", priority = 3)
	public void testTimelineTrainersPerPage() {
		
		System.out.println("input1:" + input1);
		
		// don't need to navigate to batches page because you're already there

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='pagination.perPage']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='pagination.perPage']")).getText();
		System.out.println("testTimelineTrainersPerPage - locationInBatch: " + locationInBatch);
		
		if(locationInBatch.toLowerCase().contains(input1.toLowerCase())) {
			System.out.println("You Win!!");
		} else {
			System.out.println("You Failed!! Try Again!");
		}
	}
	
	@Test(enabled = true, groups = "VP", priority = 4)
	public void testOutgoingGrads() {
		
		System.out.println("input2: " + input2);

		// Navigating to the Reports Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a"))).click().build().perform();
//		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a").click();

		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }			// timer for page to fully load
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='rCtrl.graduates']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model*='rCtrl.graduates']")).getText();
		System.out.println("testOutgoingGrads - locationInBatch: " + locationInBatch);
		
		if(locationInBatch.toLowerCase().contains(input2.toLowerCase())) {
			System.out.println("You Win!!");
		} else {
			System.out.println("You Failed!! Try Again!");
		}
	}
	
	@Test(enabled = true, groups = "VP", priority = 5)
	public void testIncomingTrainees() {
		
		System.out.println("input3: " + input3);

		// don't need to navigate to reports page because you're already there		

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='rCtrl.incoming']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='rCtrl.incoming']")).getText();
		System.out.println("locationInBatch: " + locationInBatch);
		
		if(locationInBatch.toLowerCase().contains(input3.toLowerCase())) {
			System.out.println("You Win!!");
		} else {
			System.out.println("You Failed!! Try Again!");
		}
	}
	
	// ----- Testing Settings Page As A Trainer -----
	@Test(enabled = true, groups = "Trainer", priority = 6)
	public void testSettingsPageAsTrainer() {

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
