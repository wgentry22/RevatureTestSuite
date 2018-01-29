package com.revature.tester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ReportsPage;

public class ReportTester {

	static WebDriver wd = null;
	
	@BeforeGroups(enabled = true, groups = "VP")
	public static void loginAsVP() {
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");

		ReportsPage.navigateToReportsPage(wd);
	}
	
	@Test(enabled = true, groups = "VP")
	public static void testBatchProjection() {
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// wait for page to load
		ReportsPage.batchProjectionToolbar(wd).click();
		ReportsPage.addNewCardButton(wd).click();
		ReportsPage.batchArrowButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP")
	public static void testGraduateSummary() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }		// wait for page to load
		ReportsPage.gradArrowButton(wd).click();
		ReportsPage.exportToCSV1(wd).click();
		ReportsPage.gradToolbar(wd).click();
	}
	
	@Test(enabled = true, groups = "VP")
	public static void testIncomingTraineeSummary() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }		// wait for page to load
		ReportsPage.incomingTraineeToolbar(wd).click();
		ReportsPage.exportToCSV2(wd).click();
		ReportsPage.incArrowButton(wd).click();
	}
	
}
