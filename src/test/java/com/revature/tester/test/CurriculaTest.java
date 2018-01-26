package com.revature.tester.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.CirriculaPage;

public class CurriculaTest {

	WebDriver driver = DriverFactory.getDriver("chrome");
	
  @Test(enabled=false, priority=0)
  public void cycleThroughAllTabs() {
	  CirriculaPage.overviewTab(driver).click();
	  CirriculaPage.batchesTab(driver).click();
	  CirriculaPage.locationsTab(driver).click();
	  CirriculaPage.curriculaTab(driver).click();
	  CirriculaPage.trainersTab(driver).click();
	  CirriculaPage.reportsTab(driver).click();
	  CirriculaPage.settingsTab(driver).click();
  }
  
  @Test(enabled=true, priority = 0)
  public void testCurriculaTab() {
	  CirriculaPage.curriculaTab(driver).click();
  }
  
  @Test()
  public void testCoreCurriculaPanel() {
	  CirriculaPage.toggleCoreCurriculaPanel(driver).click();
	  //Sleeping for 1 second to illustrate that the panel click works
	  try {
		  Thread.sleep(1000);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  CirriculaPage.toggleCoreCurriculaPanel(driver).click();
  }

  @Test()
  public void testFocusPanel() {
	  CirriculaPage.toggleFocusPanel(driver).click();
	  //Sleeping for 1 second to illustrate that the panel click works
	  try {
		  Thread.sleep(1000);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  CirriculaPage.toggleFocusPanel(driver).click();
  }
  

  @BeforeTest
  public void beforeTest() {
	  CirriculaPage.loginVPCredentials(driver);
	  //LoginTester go
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
