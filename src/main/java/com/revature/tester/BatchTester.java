package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.BatchPage;

public class BatchTester {
	static WebDriver wd = DriverFactory.getDriver("chrome");
	static Properties props;
	
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
		wd.get("https://dev.assignforce.revaturelabs.com/batches");
		// input new batch info into fields
		fillInputs();
		// submit button/create new batch
		BatchPage.getBatchSubmitBtn(wd).click();
	}
	
	@Test(groups= {"VP"})
	public static void testVPCancelBatchCreation() {
		// navigate to correct page
		wd.get("https://dev.assignforce.revaturelabs.com/batches");
		// input new batch info into fields
		fillInputs();
		// hit button to cancel new batch creation
		BatchPage.getBatchCancelBtn(wd).click();
	}
}
