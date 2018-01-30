package com.revature.tester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ReportsPage;

public class ReportTester {

	WebDriver wd = null;
	
	@BeforeGroups(enabled = true, groups = "VP")
	public void loginAsVP() {
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");

//		ReportsPage.navigateToReportsPage(wd);
		MethodUtil.waitForLoad(wd, "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a").click();
	}
	
	@AfterGroups(enabled = true, groups = "VP")
	public void logout() {
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.logout(wd).click();
		try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}
	
	@Test(enabled = true, groups = "VP")
	public void testBatchProjection() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }		// wait for page to load
		ReportsPage.batchProjectionToolbar(wd).click();
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.addNewCardButton(wd).click();
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.batchArrowButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP")
	public void testGraduateSummary() {
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }		// wait for page to load
		ReportsPage.gradArrowButton(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.exportToCSV1(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.gradToolbar(wd).click();
	}
	
	@Test(enabled = true, groups = "VP")
	public void testIncomingTraineeSummary() {
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }		// wait for page to load
		ReportsPage.incomingTraineeToolbar(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.exportToCSV2(wd).click();
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.incArrowButton(wd).click();
	}
	
}
