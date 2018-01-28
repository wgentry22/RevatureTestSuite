package com.revature.tester.test;


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
import com.revature.tester.MethodUtil;

public class TrainerTestTest {
	WebDriver wd = DriverFactory.getDriver("chrome");
  @Test(groups= {"VP", "trainer"})
  public void clickTrainersTab() { 
	  TrainerPage.selectTrainersTab(wd);
  }
  
  @Test(groups= {"VP"}, priority=1, enabled=false)
  public void addTrainerSave() {
	  TrainerPage.selectAddTrainer(wd).click();
	  writeTrainerFullName();
	  clickAcceptTrainerInput();
  }
 //@Test(groups= {"VP"}, priority=2)
  public void addTrainerCancel() {
	  TrainerPage.selectAddTrainer(wd).click();
	  clickCancelTrainerInput();
	  //TrainerPage.selectCancelAddTrainer(wd).click();
  }
  
  @Test(groups= {"VP"}, priority=9)
  public void checkPTOCalendar() {
	  beforeMethod();
	  clickPTOCalendar();
	  clickNewPTORequest();
	  clickCancelPTORequest();
	  beforeMethod();
	  clickCancelPTOCalendar();
  }
  
  public void clickCancelPTOCalendar() {
	  MethodUtil.executeJSClick(wd,TrainerPage.selectCancelCalendar(wd));
  }
  
  //@Test(groups= {"VPAccept","VPDeny"}, dependsOnMethods="clickAddTrainer", priority=1)
  public void writeTrainerFullName() {
	  TrainerPage.insertTrainerFirstname(wd).sendKeys("Testing");
	  TrainerPage.insertTrainerLastname(wd).sendKeys("Testing");
	 // clickAcceptTrainerInput();
  }
  
  //@Test(groups= {"VPAccept"}, dependsOnMethods="writeTrainerFullName", priority=1)
  public void clickAcceptTrainerInput() {
	  TrainerPage.selectSaveNewTrainer(wd).click();
  }
  
  //@Test(groups= {"VPDeny"}, dependsOnMethods="clickAddTrainer", priority=1)
  public void clickCancelTrainerInput() {
	  TrainerPage.selectCancelAddTrainer(wd).click();
  }
  
  //@Test(groups= {"VPAccept"}, priority=2)
  public void addNewPTORequest() {
	  clickPTOCalendar();
	  clickNewPTORequest();
  }
  public void cancelAddNewPTORequest() {
	  clickPTOCalendar();
	  clickNewPTORequest();
	  clickCancelPTORequest();
  }
  public void clickPTOCalendar() {
	  TrainerPage.selectViewPTOCalendar(wd).click();
  }
  
  //@Test(groups= {"VPAccept"}, dependsOnMethods="clickPTOCalendar", priority=6)
  public void clickNewPTORequest() {
		  TrainerPage.selectAddPTORequest(wd).click();
  }
  
  //@Test(groups= {"VPDeny"}, dependsOnMethods="clickPTOCalendar", priority=7)
  public void clickCancelPTORequest() {
	  TrainerPage.selectCancelPTORequest(wd).click();
  }
  
  @Test(groups= {"VP"}, priority=4, enabled=false)
  public void clickProfile() {
	  TrainerPage.selectProfile(wd).click();
	  wd.navigate().back();
  }
  
  @Test(groups= {"VP"}, priority=5, enabled=false)
  public void clickDeactivateTrainer() {
	  TrainerPage.selectDeactivateTrainer(wd);
  }
  
  @Test(groups= {"VP"}, priority=6, enabled=false)
  public void clickReactivateTrainer() {
	 TrainerPage.selectReactivateTrainer(wd).click();
  }
  
  @Test(groups= {"VP"}, priority=7)
  public void clickDownloadResume() {
	  TrainerPage.selectDownloadResume(wd).click();
  }
  
  @BeforeMethod(groups= {"VP","trainer"})
  public void beforeMethod() {
	  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }

  @AfterMethod
  public void afterMethod() {
	  TrainerPage.selectTrainersTab(wd);
  }

  @BeforeClass(groups= {"VP","trainer"})
  public void signInAsVPToTrainers() {
	  LoginPage.goToAssignForce(wd);
	  LoginPage.getUsernameInput(wd).sendKeys("test.vpoftech@revature.com.int1");
	  LoginPage.getPasswordInput(wd).sendKeys("yuvi1712");
	  LoginPage.getLoginBtn(wd).submit();
	  TrainerPage.selectTrainersTab(wd).click();
  }

  @AfterClass(groups= {"VP","trainer"})
  public void afterClass() {
	  MethodUtil.executeJSClick(wd, TrainerPage.selectLogout(wd));
	  MethodUtil.waitAndCloseDriver(wd, 1000);
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
