package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.revature.pageObjectModel.BatchPage;

public class BatchTester {
	WebDriver wd;
	Properties props;
	
	@Test(groups= {"VP"})
	public void testVPCreateBatch() {
		// navigate to correct page
		wd.get("");
		// input new batch info into fields
		BatchPage.getBatchCurriculumInput(wd).sendKeys("Java");
		BatchPage.getBatchFocusInput(wd).sendKeys("Testing");
		BatchPage.getBatchSkillsInput(wd).sendKeys("Automation");
		BatchPage.getBatchTrainerInput(wd).sendKeys("Yuvi");
		BatchPage.getBatchCoTrainerInput(wd).sendKeys("N/A");
		BatchPage.getBatchStartDateInput(wd).sendKeys("12/08/2017");
		BatchPage.getBatchEndDateInput(wd).sendKeys("03/08/2018");
		BatchPage.getBatchWeekSpanInput(wd).sendKeys("11");
		BatchPage.getBatchLocationInput(wd).sendKeys("DC");
		BatchPage.getBatchBuildingInput(wd).sendKeys("11730");
		BatchPage.getBatchRoomInput(wd).sendKeys("201");
		// submit button/create new batch
		BatchPage.getBatchSubmitBtn(wd).click();
	}
}
