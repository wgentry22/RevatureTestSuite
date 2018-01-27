package com.revature.tester.test;

import java.io.IOException;

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
	
  @Test(enabled=false)
  public void testBatchesTab() {
	  CirriculaPage.batchesTab(driver).click();
  }
  
  @Test(enabled=false)
  public void testLocationsTab() {
	  CirriculaPage.locationsTab(driver).click();
  }
  
  @Test(enabled=false)
  public void testTrainersTab() {
	  CirriculaPage.trainersTab(driver).click();
  }
  
  @Test(enabled=false)
  public void testReportsTab() {
	  CirriculaPage.reportsTab(driver).click();
  }
  
  @Test(enabled=false)
  public void testSettingsTab() {
	  CirriculaPage.settingsTab(driver).click();
  }
  
  @Test(enabled=true, priority = 0)
  public void testCurriculaTab() {
	 CirriculaPage.curriculaTab(driver).click();
  }
  
  @Test(enabled=true, priority=1)
  public void testCoreCurriculaPanel() {
	  CirriculaPage.toggleCoreCurriculaPanel(driver).click();
	  //Sleeping for 1 second to illustrate that the panel click works
//	  try {
//		  Thread.sleep(2000);
//	  } catch (InterruptedException e) {
//		  e.printStackTrace();
//	  }
	  CirriculaPage.toggleCoreCurriculaPanel(driver).click();
  }

  @Test(enabled=true, priority=2)
  public void testFocusPanel() {
	  CirriculaPage.toggleFocusPanel(driver).click();
	  //Sleeping for 1 second to illustrate that the panel click works
//	  try {
//		  Thread.sleep(2000);
//	  } catch (InterruptedException e) {
//		  e.printStackTrace();
//	  }
	  CirriculaPage.toggleFocusPanel(driver).click();
  }
  
  @Test(enabled=true, priority=3)
  public void testRemoveCurricula() {
	  CirriculaPage.toggleFocusPanel(driver).click();
	  CirriculaPage.removeCurriculaButton(driver).click();
	  
	  CirriculaPage.cancelRemoveCurriculumButton(driver).click();
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
