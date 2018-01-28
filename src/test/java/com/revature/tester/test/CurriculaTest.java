package com.revature.tester.test;

import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.CirriculaPage;
import com.revature.tester.MethodUtil;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class CurriculaTest {

	WebDriver driver = DriverFactory.getDriver("chrome");
  @BeforeTest
  public void beforeTest() {
	  CirriculaPage.loginVPCredentials(driver);
  }

  @AfterTest
  public void afterTest() {
	  MethodUtil.executeJSClick(driver, CirriculaPage.logoutTab(driver));
  }

  @BeforeSuite
  public void beforeSuite() {
	  CirriculaPage.openSalesforceChrome(driver);
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
	  driver.quit();
  }
  
  @Test(priority=1, enabled=true)
  public void navigateToCurriculumTab() {
	  CirriculaPage.curriculaTab(driver).click();
  }
  
  
  @Test(priority=2, enabled=true)
  public void openCurriculaPanel() {
	  if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
		  return;
	  } else {
		  CirriculaPage.toggleCoreCurriculaPanel(driver).click();
	  }
  }
  
  
  /* Works for both cancel and confirm removing a curriculum */
  
  @Test(priority=3, enabled=true)
  public void removeNthCurriculaButton() {
	  try {
		  CirriculaPage.removeNthCurriculaButton(driver, 1).click();
		  Thread.sleep(1000);
		  
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  try {
		  CirriculaPage.cancelRemoveCurriculumButton(driver).click();
		  Thread.sleep(250);
		  
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }
  
  
  @Test(priority=4, enabled=true)
  public void editCurriculaButtonAndUpdateName() {
	  try {
		  Thread.sleep(400);
		  CirriculaPage.editNthCurriculaPanelButton(driver, 1).click();
		  Thread.sleep(400);
		  CirriculaPage.editCurriculumNameInputField(driver).clear();
		  Thread.sleep(400);
		  CirriculaPage.editCurriculumNameInputField(driver).sendKeys("Not William");
		  Thread.sleep(800);
	  } catch (InterruptedException e) {
		  CirriculaPage.cancelButtonEditFocusPopup(driver).click();
	  }
	  CirriculaPage.confirmButtonEditCurriculumPopup(driver).click();
  }
  
  @Test(priority=5, enabled=true)
  public void openFocusPanel() {
	  if (CirriculaPage.isFocusPanelOpen(driver)) {
		  return;
	  } else {
		  CirriculaPage.toggleFocusPanel(driver).click();
	  }
  }
  
  @Test(priority=6, enabled=false)
  public void editFocusButtonOpenAndClose() {
	  CirriculaPage.editFirstFocusPanelButton(driver).click();
	  CirriculaPage.cancelButtonEditFocusPopup(driver).click();
  }
  
  @Test(priority=7, enabled=true)
  public void editFocusButtonAndEditName() {
	  try {
		  Thread.sleep(400);
		  CirriculaPage.editFirstFocusPanelButton(driver).click();
		  Thread.sleep(400);
		  CirriculaPage.textInputEditFocusPopup(driver).clear();
		  Thread.sleep(400);
		  CirriculaPage.textInputEditFocusPopup(driver).sendKeys("Ruby on Rails");
		  Thread.sleep(800);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
		  CirriculaPage.cancelButtonEditFocusPopup(driver).click();
	  }
	  CirriculaPage.confirmButtonEditFocusPopup(driver).click();
  }
  
  
  @Test(priority=8, enabled=true)
  public void removeFocusButton() {
	  try {
		  Thread.sleep(300);
		  MethodUtil.executeJSClick(driver, CirriculaPage.removeNthButtonFocus(driver, 1));
		  Thread.sleep(300);
		  MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonRemoveFocus(driver));
		  Thread.sleep(200);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }

  
  @Test(priority=9, enabled=true)
  public void addSkill() {
	  try {
		  Thread.sleep(250);
		  CirriculaPage.addSkill(driver).sendKeys("WebDriver");
		  Thread.sleep(250);
		  MethodUtil.executeJSClick(driver, CirriculaPage.createButtonSkill(driver));
		  Thread.sleep(250);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }
  
}
