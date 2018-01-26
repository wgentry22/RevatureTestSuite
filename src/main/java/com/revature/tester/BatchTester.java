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
	static Properties props;
	
	@BeforeClass
	public static void doLogin() {
		MethodUtil.loadPropertiesFile(props);
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("VPUsername"),props.getProperty("VPPassword"));
	}
	
	@AfterClass
	public static void doLogout() {
		MethodUtil.waitForLoad(wd, "(//button)[1]").click();
	}
	
	@AfterSuite
	public static void closeDriver() {
		MethodUtil.waitAndCloseDriver(wd,Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	
	public static void fillInputs() {
		BatchPage.getBatchCurriculumSelect(wd).click();
		BatchPage.getBatchCurriculumOption(wd).click();
		BatchPage.getBatchFocusSelect(wd).click();
		BatchPage.getBatchFocusOption(wd).click();
		BatchPage.getBatchSkillsSelect(wd).click();
		BatchPage.getBatchSkillsOption(wd).click();
		BatchPage.getBatchTrainerSelect(wd).click();
		BatchPage.getBatchTrainerOption(wd).click();
		BatchPage.getBatchCoTrainerSelect(wd).click();
		BatchPage.getBatchCoTrainerOption(wd).click();
		BatchPage.getBatchStartDateInput(wd).sendKeys("12/11/2017");
		BatchPage.getBatchEndDateInput(wd).sendKeys("03/11/2018");
		// Don't need to mess with week span
		//BatchPage.getBatchWeekSpanInput(wd).click();
		BatchPage.getBatchLocationSelect(wd).click();
		BatchPage.getBatchLocationOption(wd).click();
		BatchPage.getBatchBuildingSelect(wd).click();
		BatchPage.getBatchBuildingOption(wd).click();
		BatchPage.getBatchRoomSelect(wd).click();
		BatchPage.getBatchRoomOption(wd).click();
	}
	
	@Test(groups= {"VP"})
	public static void testVPCreateBatch() {
		// navigate to correct page
		wd.get(props.getProperty("BatchesURL"));
		// input new batch info into fields
		fillInputs();
		// submit button/create new batch
		//BatchPage.getBatchSubmitBtn(wd).click();
	}
	
	@Test(enabled=false,groups= {"VP"})
	public static void testVPCancelBatchCreation() {
		// navigate to correct page
		wd.get(props.getProperty("BatchesURL"));
		// input new batch info into fields
		fillInputs();
		// hit button to cancel new batch creation
		BatchPage.getBatchCancelBtn(wd).click();
	}
}
