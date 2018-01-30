package com.revature.tester;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.model.Skill;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.BatchPage;
import com.revature.pageObjectModel.LoginPage;

public class BatchTester {
	WebDriver wd = DriverFactory.getDriver("chrome");
	Properties props = new Properties();
	
	String err = " not input correctly";
	Batch b = new Batch();
	com.revature.hibernate.model.Batch batch = AssignForce.getAllBatches().get(2);

	@BeforeClass
	public void doLogin() {
		MethodUtil.loadPropertiesFile(props);
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("VPUsername"), props.getProperty("VPPassword"));
		// go to batches tab
		MethodUtil.waitForLoad(wd, "//a[@ng-href=\"batches\"]",20).click();
	}

	@AfterClass
	public void doLogout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // wait 2 seconds
		MethodUtil.executeJSClick(wd, MethodUtil.waitForLoad(wd, "(//button)[1]"));
		MethodUtil.waitAndCloseDriver(wd, Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}

	@Test(groups = { "VP" }, priority = 1)
	public void fillCurriculum() {
		BatchPage.getBatchCurriculumSelect(wd).click();
		BatchPage.getBatchCurriculumOption(wd, batch.getCurriculumName()).click();
		assertTrue(BatchPage.getBatchCurriculumSelect(wd).getText().contains(batch.getCurriculumName()),"Curriculum"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 2)
	public void fillFocus() {
		BatchPage.getBatchFocusSelect(wd).click();
		BatchPage.getBatchFocusOption(wd, batch.getFocusName()).click();
		assertTrue(BatchPage.getBatchFocusSelect(wd).getText().contains(batch.getFocusName()),"Focus"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 3)
	public void fillSkills() {
		for (Skill s : batch.getAllRequiredSkills()) {
			BatchPage.getBatchSkillsSelect(wd).click();
			BatchPage.getBatchSkillsOption(wd, s.getSkillName()).click();
			assertTrue(BatchPage.getBatchSkillsSelect(wd).getText().contains(s.getSkillName()),"Skills"+err);
		}
			MethodUtil.executeJSClick(wd, wd.findElement(By.id("batchInfoDiv")));
	}
	@Test(enabled=true,groups = { "VP" }, priority = 4)
	public void fillStartDate() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchStartDateInput(wd));
		BatchPage.getBatchStartDateInput(wd).clear();
		BatchPage.getBatchStartDateInput(wd).sendKeys(b.start);
		assertEquals(BatchPage.getBatchStartDateInput(wd).getAttribute("value"),b.start,"Start date"+err);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(enabled=true,groups = { "VP" }, priority = 5)
	public void fillEndDate() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchEndDateInput(wd));
		BatchPage.getBatchEndDateInput(wd).clear();
		BatchPage.getBatchEndDateInput(wd).sendKeys(b.end);
		assertEquals(BatchPage.getBatchEndDateInput(wd).getAttribute("value"),b.end,"End date"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 6)
	public void showAccurateWeekspan() {
		assertEquals(BatchPage.getBatchWeekSpanInput(wd).getAttribute("value"),"Spans "+b.weekspan+" Weeks","Weekspan"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 7)
	public void fillBatchName() {
		BatchPage.getBatchNameInput(wd).clear();
		BatchPage.getBatchNameInput(wd).sendKeys(batch.getBatchName());
		System.out.println("BATCH NAME INPUT :");
		System.out.println(BatchPage.getBatchNameInput(wd).getAttribute("value"));
		assertTrue(BatchPage.getBatchNameInput(wd).getAttribute("value").contains(batch.getBatchName()),"Batch Name"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 8)
	public void fillTrainer() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchTrainerSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchTrainerOption(wd, batch.getTrainerName()));
		assertTrue(BatchPage.getBatchTrainerSelect(wd).getText().contains(batch.getTrainerName()),"Trainer"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 9)
	public void fillCoTrainer() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCoTrainerSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCoTrainerOption(wd, b.cotrainer));
		assertTrue(BatchPage.getBatchCoTrainerSelect(wd).getText().contains(b.cotrainer),"Co-trainer"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 10)
	public void fillLocation() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchLocationSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchLocationOption(wd, batch.getLocationName()));
		assertTrue(BatchPage.getBatchLocationSelect(wd).getText().contains(batch.getLocationName()),"Location"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 11)
	public void fillBuilding() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchBuildingSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchBuildingOption(wd, batch.getBuildingName()));
		assertTrue(BatchPage.getBatchBuildingSelect(wd).getText().contains(batch.getBuildingName()),"Building"+err);
	}
	@Test(enabled=true,groups = { "VP" }, priority = 12)
	public void fillRoom() {
		MethodUtil.executeJSClick(wd, BatchPage.getBatchRoomSelect(wd));
		MethodUtil.executeJSClick(wd, BatchPage.getBatchRoomOption(wd, batch.getRoomName()));
		assertTrue(BatchPage.getBatchRoomSelect(wd).getText().contains(batch.getRoomName()),"Room"+err);
	}

	@Test(enabled=true,groups = { "VP" }, priority = 13)
	public void testVPCreateBatch() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// submit button/create new batch
		MethodUtil.executeJSClick(wd, BatchPage.getBatchSubmitBtn(wd));
	}

	@Test(enabled=true,groups = { "VP" }, priority = 14)
	public void testVPCancelBatchCreation() {
		fillCurriculum();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// hit button to cancel new batch creation
		MethodUtil.executeJSClick(wd, BatchPage.getBatchCancelBtn(wd));
		assertFalse(BatchPage.getBatchCurriculumSelect(wd).getText().contains(b.curriculum),"Curriculum was not cleared when cancel button was clicked");
	}

	@Test(enabled=true,groups = { "VP" }, priority = 15)
	public void testRefresh() {
		wd.get(props.getProperty("BatchesURL"));
		assertTrue(MethodUtil.waitForLoad(wd, "//div[@id=\"batchInfoDiv\"]").getText().contains("Create New Batch"),"Create new batch panel does not exist on refresh");
	}
}

class Batch {
	public String curriculum = ".NET";
	public String focus = "No Focus";
	public String skills = "JSP";
	public String start = "02/05/2018";
	public String end = "04/13/2018";
	public String weekspan = "10";
	public String name = "TestBatch";
	public String trainer = "Test Trainer";
	public String cotrainer = "Testing Testing";
	public String location = "New York City";
	public String building = "CUNY QUEENS";
	public String room = "1";
}