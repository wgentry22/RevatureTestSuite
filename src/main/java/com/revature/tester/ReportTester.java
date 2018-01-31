package com.revature.tester;

import org.openqa.selenium.By;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ReportsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportTester {

	WebDriver wd = null;
	Properties props;

	public ReportTester(WebDriver wd2, Properties props2) {
		this.wd = wd2;
		this.props = props2;
	}

	public ReportTester() {}

	@BeforeGroups(enabled = true, groups = "VP")
	public void loginAsVP() throws Throwable {

		// Logging In The VP
		System.out.println("Login As VP");
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");

		// need these for explicit waits won't work
		wait = new WebDriverWait(wd, 5);
		act = new Actions(wd);

		// Navigating to the Reports Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a")));
		act.moveToElement(wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a"))).click().build().perform();
	}

	@AfterGroups(enabled = true, groups = "VP")
	public void logout() {
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		ReportsPage.logout(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
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
