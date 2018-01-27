package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.BatchPage;
import com.revature.pageObjectModel.LoginPage;

public class BatchTester {
	static WebDriver wd = DriverFactory.getDriver("chrome");
	static Properties props = new Properties();
	
	@BeforeClass
	public static void doLogin() {
		MethodUtil.loadPropertiesFile(props);
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("VPUsername"),props.getProperty("VPPassword"));
		// go to batches tab
		MethodUtil.waitForLoad(wd, "//a[@ng-href=\"batches\"]").click();
	}
	
	@AfterClass
	public static void doLogout() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // wait 5 seconds
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "(//button)[1]"));
		MethodUtil.waitAndQuitDriver(wd, Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	
	@AfterSuite
	public static void closeDriver() {
		MethodUtil.waitAndQuitDriver(wd,Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	
	public static void fillInputs() {
		BatchPage.getBatchCurriculumSelect(wd).sendKeys("Java");
		BatchPage.getBatchFocusSelect(wd).sendKeys("No Focus");
		BatchPage.getBatchSkillsSelect(wd).sendKeys("JSP");
		BatchPage.getBatchStartDateInput(wd).sendKeys("12/11/2017");
		BatchPage.getBatchEndDateInput(wd).sendKeys("03/11/2018");
		BatchPage.getBatchNameInput(wd).sendKeys("TestBatch");
		BatchPage.getBatchTrainerSelect(wd).sendKeys("Test Trainer");
		BatchPage.getBatchCoTrainerSelect(wd).sendKeys("Test Co-Trainer");
		// Don't need to mess with week span                        
		//BatchPage.getBatchWeekSpanInput(wd).sendKeys();
		BatchPage.getBatchLocationSelect(wd).sendKeys("Revature HQ - Reston, VA");
		BatchPage.getBatchBuildingSelect(wd).sendKeys("Reston 11730");
		BatchPage.getBatchRoomSelect(wd).sendKeys("1");
	}
	
	@Test(groups= {"VP"}, priority=1)
	public static void testVPCreateBatch() {
		// input new batch info into fields
		fillInputs();
		// submit button/create new batch
		MethodUtil.executeJSClick(wd, BatchPage.getBatchSubmitBtn(wd));
	}
	
	@Test(groups= {"VP"}, priority=2)
	public static void testVPCancelBatchCreation() {
		// input new batch info into fields
		fillInputs();
		// hit button to cancel new batch creation
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCancelBtn(wd));
	}
	
	@Test(groups= {"VP"}, priority=3)
	public static void testRefresh() {
		wd.get(props.getProperty("BatchesURL"));
		testVPCreateBatch();
	}
}
