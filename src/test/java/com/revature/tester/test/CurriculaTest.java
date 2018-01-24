package com.revature.tester.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.Chrome;
import com.revature.pageObjectModel.CirriculaPage;

public class CurriculaTest {

	WebDriver driver = Chrome.selectDriver();
	
  @Test
  public void f() {
	  CirriculaPage.overviewTab(driver);
	  CirriculaPage.batchesTab(driver);
	  CirriculaPage.locationsTab(driver);
	  CirriculaPage.curriculaTab(driver);
	  CirriculaPage.trainersTab(driver);
	  CirriculaPage.reportsTab(driver);
	  CirriculaPage.settingsTab(driver);
  }
  

  @BeforeTest
  public void beforeTest() {
	  CirriculaPage.loginVPCredentials(driver);
//	  CirriculaPage.authenticate(driver);
  }

  @AfterTest
  public void afterTest() {
	  CirriculaPage.logoutTab(driver).click();
  }

  @BeforeSuite
  public void beforeSuite() {
	  CirriculaPage.openSalesforceChrome(driver);
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
  }

}
