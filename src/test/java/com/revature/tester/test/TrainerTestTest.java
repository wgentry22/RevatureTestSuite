package com.revature.tester.test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.TrainerPage;

public class TrainerTestTest {
	WebDriver wd = DriverFactory.getDriver("chrome");
  @Test(groups= {"VP","Trainer"}, priority=0)
  public void clickTrainersTab() { 
	  try {
		  TrainerPage.selectTrainersTab(wd);
	  } catch(Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test(groups="VP", priority=1)
  public void clickAddTrainer() {
	  TrainerPage.selectAddTrainer(wd).click();
	  assertTrue(true);
  }
  @Test(groups="VP")
  public void writeTrainerFullName(String firstname, String lastname) {
	  try {
		  TrainerPage.insertTrainerFirstname(wd).sendKeys(firstname);
		  TrainerPage.insertTrainerLastname(wd).sendKeys(lastname);
	  } catch(Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test(groups="VP")
  public void acceptTrainerInput() {
	  try {
		  TrainerPage.selectSaveNewTrainer(wd).click();
	  } catch(Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test(groups="VP")
  public void clickCancelTrainerInput() {
	  try {
		  TrainerPage.selectCancelAddTrainer(wd).click();
	  } catch (Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test(groups="VP")
  public void clickPTOCalendar() {
	  try {
		  TrainerPage.selectViewPTOCalendar(wd).click();
	  } catch (Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test(groups="VP")
  public void clickNewPTORequest() {
	  try {
		  TrainerPage.selectAddPTORequest(wd).click();
	  } catch (Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test
  public void clickCancelPTORequest() {
	  try {
		  TrainerPage.selectCancelPTORequest(wd).click();
	  } catch (Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test
  public void clickDownloadResume() {
	  try {
		  TrainerPage.selectCancelAddTrainer(wd).click();
	  } catch (Exception e) {
		  fail();
	  }
	  assertTrue(true);
  }
  
  @Test
  public void clickDeactivateTrainer() {
	  TrainerPage.selectDeactivateTrainer(wd);
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void signInAsVP() {
	  LoginPage.getUsernameInput(wd).sendKeys("test.vpoftech@revature.com.int1");
	  LoginPage.getPasswordInput(wd).sendKeys("yuvi1712");
	  LoginPage.getLoginBtn(wd).submit();
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
