package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ReportsPage;
import com.revature.pageObjectModel.SettingsPage;

public class SettingTester {

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

		input1 = "10";
		input2 = "12";
		input3 = "25";
		input4 = "20";
		input5 = "30";
		input6 = "10";
		input7 = "14";

		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");

		wait = new WebDriverWait(wd, 5);
		act = new Actions(wd);

		// can only input ONE word. will fail if you try to input more than one
		locationInSettings = "Revature";
		buildingInSettings = "11730";
//		locationInSettings = "New";				// New York City
//		buildingInSettings = "CUNY";			// Main Office

//		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a"))).click().build().perform();
	}

	@BeforeGroups(enabled = true, groups = "Trainer")
	public void loginAsTrainer() {
		System.out.println("BeforeTest - Trainer");

		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");

		wait = new WebDriverWait(wd, 5);
		act = new Actions(wd);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a"))).click().build().perform();
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
		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys(input1);
	}

	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testReportsOutgoingGrads() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.reportGrads']")));
		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys(input2);
	}

	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testReportsIncomingCandidates() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.reportIncomingGrads']")));
		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys(input3);
	}

	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testDefaultLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.defaultLocation']")));
		SettingsPage.defaultLocation(wd).sendKeys(locationInSettings);
	}

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
		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys(input4);
	}

	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testMaxBatchSize() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.maxBatchSize']")));
		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys(input5);
	}

	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testDefaultBatchLength() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.batchLength']")));
		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys(input6);
	}

	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testMinBetweenTrainerBatch() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.trainerBreakDays']")));
		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys(input7);
	}

	@Test(enabled = true, groups = {"VP"}, priority = 0)
	public void testSaveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='sCtrl.updateSettings()']")));
		act.moveToElement(SettingsPage.findSaveButton(wd)).click().build().perform();
	}

	// -------- Group Test --------
	@Test(enabled = false, groups = {"VP"}, priority = 0)
	public void testSettingsPageAsVP() {}
	// -------- Tests to make sure changes were saved --------
	@Test(enabled = true, groups = "VP", priority = 1)
	public void testTheDefaultLocation() {

		// Navigating to the Batch Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a"))).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bCtrl.batch.location']")));
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='bCtrl.batch.location']")).getText();

		Assert.assertTrue(locationInBatch.contains(locationInSettings));
	}

	// -------------------- FAILING TESTS --------------------
	@Test(enabled = true, groups = {"VP"}, priority = 3)
	public void testDefaultBuilding() {

		// navigate back to the settings page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a"))).click().build().perform();

		// input a building
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='sCtrl.settings.defaultBuilding']")));
		SettingsPage.defaultBuilding(wd).sendKeys(locationInSettings);

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

		// navigate to batches
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a"))).click().build().perform();

		// check if it saved in batches
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bCtrl.batch.building']")));
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='bCtrl.batch.building']")).getText();

		// verify that it saved
		Assert.assertTrue(locationInBatch.toLowerCase().contains(buildingInSettings.toLowerCase()));
	}

	@Test(enabled = true, groups = "VP", priority = 3)
	public void testTimelineTrainersPerPage() {

		System.out.println("input1:" + input1);

		// don't need to navigate to batches page because you're already there

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='pagination.perPage']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='pagination.perPage']")).getText();
		System.out.println("testTimelineTrainersPerPage - locationInBatch: " + locationInBatch);

		Assert.assertEquals(locationInBatch.toLowerCase(), input1);
	}

	@Test(enabled = true, groups = "VP", priority = 4)
	public void testOutgoingGrads() {

		System.out.println("input2: " + input2);

		// Navigating to the Reports Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a"))).click().build().perform();

		// clicking the settings button in Graduate Summary Toolbar
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view\"]/md-card/md-card[2]/get-train-table-toolbar/md-toolbar/md-menu/button")));
//		System.out.println("before");
//		act.moveToElement(ReportsPage.gradSettingsButton(wd)).click().build().perform();
//		System.out.println("after");

		// getting the information from the field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='rCtrl.graduates']")));
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='rCtrl.graduates']")).getText();
		System.out.println("testOutgoingGrads - locationInBatch: " + locationInBatch);

		Assert.assertEquals(locationInBatch, input2);
	}

	@Test(enabled = true, groups = "VP", priority = 5)
	public void testIncomingTrainees() {

		System.out.println("input3: " + input3);

		// don't need to navigate to reports page because you're already there
		// Navigating to the Reports Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a"))).click().build().perform();

		// clicking the settings button in the Incoming Trainee Toolbar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view\"]/md-card/md-card[3]/get-train-table-toolbar/md-toolbar")));
		System.out.println("before1");
		act.moveToElement(ReportsPage.traineeSettingsButton(wd)).click().build().perform();
		System.out.println("after1");

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='rCtrl.incoming']")));
//		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		locationInBatch = wd.findElement(By.cssSelector("[ng-model='rCtrl.incoming']")).getText();
		System.out.println("locationInBatch: " + locationInBatch);

//		act.moveToElement(ReportsPage.incomingTraineeToolbar(wd)).click().build().perform();
//
//		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wd.findElement(By.cssSelector("[class='md-menu-backdrop md-click-catcher ng-scope']")).click();
//		act.moveToElement(wd.findElement(By.xpath("/html/body/md-backdrop"))).click().build().perform();
//
//		Assert.assertEquals(locationInBatch, input3);
	}

	// ----- Testing Settings Page As A Trainer -----
	@Test(enabled = true, groups = "Trainer", priority = 6)
	public void testSettingsPageAsTrainer() {

		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a").click();

		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }		// makes sure the page loads, before changing the fields

		SettingsPage.timelineTrainersPerPage(wd).clear();
		SettingsPage.timelineTrainersPerPage(wd).sendKeys(input1);

		SettingsPage.reportsOutgoingGrads(wd).clear();
		SettingsPage.reportsOutgoingGrads(wd).sendKeys(input2);

		SettingsPage.reportsIncomingCandidates(wd).clear();
		SettingsPage.reportsIncomingCandidates(wd).sendKeys(input3);

		SettingsPage.defaultLocation(wd).sendKeys(locationInSettings);

		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys(input4);

		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys(input5);

		SettingsPage.defaultBatchLength(wd).clear();
		SettingsPage.defaultBatchLength(wd).sendKeys(input6);

		SettingsPage.minBetweenTrainerBatch(wd).clear();
		SettingsPage.minBetweenTrainerBatch(wd).sendKeys(input7);

//		// ----- saving the changes -----
		SettingsPage.findSaveButton(wd).click();			// only available as VP
	}

	// ----- Testing Settings Page As A Trainer -----
	@Test(enabled = true, groups = "Trainer", priority = 7)
	public void testSettingsPageAsTrainer() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='sCtrl.settings.trainersPerPage']")));
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
//		String newLocation= "New";
		SettingsPage.defaultLocation(wd).sendKeys(newLocation);

		SettingsPage.minBatchSize(wd).clear();
		SettingsPage.minBatchSize(wd).sendKeys("30");

		SettingsPage.maxBatchSize(wd).clear();
		SettingsPage.maxBatchSize(wd).sendKeys("30");
	}

}
