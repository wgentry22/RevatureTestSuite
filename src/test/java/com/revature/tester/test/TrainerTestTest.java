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
  @Test(groups= {"VPAccept","VPDeny","Trainer","first"})
  public void clickTrainersTab() { 
	  TrainerPage.selectTrainersTab(wd);
  }
  
  @Test(groups= {"VPAccept","VPDeny","first"}, priority=1)
  public void clickAddTrainer() {
	  TrainerPage.selectAddTrainer(wd).click();
	  //writeTrainerFullName();
  }
  @Test(groups= {"VPAccept","VPDeny"}, dependsOnMethods="clickAddTrainer", priority=1)
  public void writeTrainerFullName() {
	  TrainerPage.insertTrainerFirstname(wd).sendKeys("Testing");
	  TrainerPage.insertTrainerLastname(wd).sendKeys("Testing");
	  clickAcceptTrainerInput();
  }
  
  //@Test(groups= {"VPAccept"}, dependsOnMethods="writeTrainerFullName", priority=3)
  public void clickAcceptTrainerInput() {
	  TrainerPage.selectSaveNewTrainer(wd).click();
  }
  
  @Test(groups= {"VPAccept","VPDeny"}, dependsOnMethods="clickAddTrainer", priority=4)
  public void clickCancelTrainerInput() {
	  TrainerPage.selectCancelAddTrainer(wd).click();
  }
  
  @Test(groups= {"VPAccept","VPDeny","first"}, priority=5)
  public void clickPTOCalendar() {
	  TrainerPage.selectViewPTOCalendar(wd).click();
  }
  
  @Test(groups= {"VPAccept"}, dependsOnMethods="clickPTOCalendar", priority=6)
  public void clickNewPTORequest() {
		  TrainerPage.selectAddPTORequest(wd).click();
  }
  
  @Test(groups= {"VPDeny"}, dependsOnMethods="clickPTOCalendar", priority=7)
  public void clickCancelPTORequest() {
	  TrainerPage.selectCancelPTORequest(wd).click();
  }
  
  @Test(groups= {"VPAccept","VPDeny","first"}, priority=8)
  public void clickProfile() {
	  TrainerPage.selectCancelAddTrainer(wd).click();
  }
  
  @Test(groups= {"VPDeny"}, priority=9)
  public void clickDeactivateTrainer() {
	  TrainerPage.selectDeactivateTrainer(wd);
  }
  
  @Test(groups= {"VPAccept"}, priority=10)
  public void clickReactivateTrainer() {
	 TrainerPage.selectReactivateTrainer(wd).click();
  }
  
  @Test(groups= {"VPAccept","VPDeny",}, priority=11)
  public void clickDownloadResume() {
	  TrainerPage.selectDownloadResume(wd).click();
  }
  
  @BeforeMethod//(groups="first")//(groups= {"VPAccept","VPDeny","trainer"})
  public void beforeMethod() {
	  try {
		Thread.sleep(230);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }

  @AfterMethod
  public void afterMethod() {
	  TrainerPage.selectTrainersTab(wd);
  }

  @BeforeClass(groups= {"VPAccept","VPDeny","trainer"})
  public void signInAsVP() {
	  LoginPage.goToAssignForce(wd);
	  LoginPage.getUsernameInput(wd).sendKeys("test.vpoftech@revature.com.int1");
	  LoginPage.getPasswordInput(wd).sendKeys("yuvi1712");
	  LoginPage.getLoginBtn(wd).submit();
	  TrainerPage.selectTrainersTab(wd).click();
  }

  @AfterClass(groups= {"VPAccept","VPDeny","trainer"})
  public void afterClass() {
	  TrainerPage.selectLogout(wd).click();
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
