package com.revature.tester.test;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TrainerTest {
	public WebDriver wd = DriverFactory.getDriver("chrome");
	
  public void clickDownloadResumeByName(String firstname, String lastname) {
	  TrainerPage.selectTrainerDownloadResumeButton(wd, firstname, lastname).click();
  }
  
  public void clickProfileByName(String firstname, String lastname) {
	  TrainerPage.selectTrainerProfileButton(wd, firstname, lastname).click();
  }
  
  
  @When("^I click cancel on the Calendar$")
  public void clickCancelPTOCalendar() {
	  MethodUtil.executeJSClick(wd,TrainerPage.selectCancelCalendar(wd));
  }
  
  @When("^I insert <firstname> and <lastname> onto the firstname and lastname inputs$")
  public void writeTrainerFullName(String firstname, String lastname) {
	  TrainerPage.insertTrainerFirstname(wd).sendKeys(firstname);
	  holdOn(500);
	  TrainerPage.insertTrainerLastname(wd).sendKeys(lastname);
  }
  
  @When("^I select save$")
  public void clickAcceptTrainerInput() {
	  TrainerPage.selectSaveNewTrainer(wd).click();
  }
  
  @When("^I select cancel$")
  public void clickCancelTrainerInput() {
	  TrainerPage.selectCancelAddTrainer(wd).click();
  }
  
  @Given("^I click on the View PTO Calendar button$")
  public void clickPTOCalendar() {
	  TrainerPage.selectViewPTOCalendar(wd).click();
  }
  
  @Given("^I click new PTO Request$")
  public void clickNewPTORequest() {
	  MethodUtil.executeJSClick(wd, TrainerPage.selectAddPTORequest(wd));
  }
  
  @When("^I click cancel PTO Request$")
  public void clickCancelPTORequest() {
	  TrainerPage.selectCancelPTORequest(wd).click();
  }
  
  public void enterPTODate(String startDate, String endDate) {
	  //TrainerPage.insertPTOStartDate(wd).click();
	  TrainerPage.selectStartDateCalendarPopup(wd).click();
	  //TrainerPage.insertPTOStartDate(wd).click();
	  //TrainerPage.insertPTOStartDate(wd).sendKeys(startDate);
	  //TrainerPage.insertPTOStartDate(wd).click();
	  TrainerPage.selectEndDateCalendarPopup(wd).click();
	  //TrainerPage.insertPTOStartDate(wd).click();
	  //TrainerPage.insertPTOEndDate(wd).sendKeys(endDate);
  }
  
  public void clickCalendarWeekView() {
	  TrainerPage.selectCalendarWeekView(wd).click();
  }
  
  public void clickCalendarMonthView() {
	  TrainerPage.selectCalendarMonthView(wd).click();
  }
  
  public void clickCalendarAgendaView() {
	  TrainerPage.selectCalendarAgendaView(wd).click();
  }
  
  public void clickCalendarBack() {
	  TrainerPage.selectMoveBackInCalendar(wd).click();
  }
  
  public void clickCalendarForward() {
	  TrainerPage.selectMoveForwardInCalendar(wd).click();
  }
  
  public void clickCalendarToday() {
	  TrainerPage.selectTodayOnCalendar(wd);
  }
  
  @Given("^I click add trainer$")
  public void clickAddTrainer() {
	  TrainerPage.selectAddTrainer(wd).click();
  }
  
  @Given("^I click on the trainers tab$")
  @Test(groups= {"VP", "Trainer"})
  public void clickTrainersTab() { 
	  TrainerPage.selectTrainersTab(wd);
  }
  
  @Test(groups= {"VP"}, priority=1, enabled=false)
  public void addTrainerSave() {
	  clickAddTrainer();
	  writeTrainerFullName("Testing1r", "Testing2p");
	  clickAcceptTrainerInput();
  }
  @Test(groups= {"VP"}, priority=2, enabled=false)
  public void addTrainerCancel() {
	  clickAddTrainer();
	  writeTrainerFullName("Testing1r", "Testing2p");
	  holdOn(500);
	  clickCancelTrainerInput();
  }
  
  @Test(groups= {"VP","Trainer"}, priority=4, enabled=true)
  public void checkPTOCalendar() {
	  holdOn(100);
	  clickPTOCalendar();
	  clickNewPTORequest();
	  holdOn(300);
	  enterPTODate("1/1/2018", "1/2/2017");
	  holdOn(1000);
	  clickCancelPTORequest();
	  clickCancelPTOCalendar();
  }
  
  @Test(groups= {"VP", "Trainer"}, priority=3, enabled=true)
  public void clickProfile() {
	  clickProfileByName("Damon", "Salvatore");
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  wd.navigate().back();
  }
  
  @Test(groups= {"VP"}, priority=5, enabled=true)
  public void clickDeactivateTrainerByName() {
	  MethodUtil.executeJSClick(wd, TrainerPage.selectTrainerDeactivateButton(wd, "Damon", "Salvatore"));
  }
  
  @Test(groups= {"VP"}, priority=6, enabled=true)
  public void clickReactivateTrainerByName() {
	  TrainerPage.selectTrainerReactivateButton(wd, "Damon", "Salvatore").click();
  }
  
  @Test(groups= {"VP"}, priority=5, enabled=false)
  public void clickDeactivateTrainer() {
	  List<WebElement> deactivatedtrainers = TrainerPage.selectDeactivatedTrainersList(wd);
	  for (WebElement de : deactivatedtrainers)
		  System.out.println(de.getText());
	  for(int i = 0; i < 5; i++)
	  TrainerPage.selectDeactivateTrainer(wd).click();
  }
  
  @Test(groups= {"VP"}, priority=6, enabled=false)
  public void clickReactivateTrainer() {
	 for(int i = 0; i < 5; i++)
	 TrainerPage.selectReactivateTrainer(wd).click();
  }
  
  @When("^I click on the Download Resume button$")
  @Test(groups= {"VP", "Trainer"}, priority=7)
  public void clickDownloadResume() {
	  //TrainerPage.selectDownloadResume(wd).click();
	  MethodUtil.executeJSClick(wd, TrainerPage.selectDownloadResume(wd));
  }
  
  @BeforeMethod(groups= {"VP","trainer"})
  public void holdOn() {
	  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }
  public void holdOn(int number) {
	  try {
		Thread.sleep(number);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }

  @Given("^I am on the trainers page$")
  @AfterMethod
  public void afterMethod() {
	  TrainerPage.selectTrainersTab(wd);
  }

  @Given("^I login as VP$")
  @BeforeClass(groups= {"VP"})
  public void signInAsVP() {
	  LoginPage.getUsernameInput(wd).sendKeys("test.vpoftech@revature.com.int1");
	  LoginPage.getPasswordInput(wd).sendKeys("yuvi1712");
	  LoginPage.getLoginBtn(wd).submit();
	  TrainerPage.selectTrainersTab(wd).click();
  }
  
  @BeforeClass(groups= {"Trainer"})
  public void signInAsTrainer() {
	  LoginPage.getUsernameInput(wd).sendKeys("test.trainer@revature.com.int1");
	  LoginPage.getPasswordInput(wd).sendKeys("trainer123");
	  LoginPage.getLoginBtn(wd).submit();
	  TrainerPage.selectTrainersTab(wd).click();
  }

  @AfterClass(groups= {"VP","Trainer"})
  public void afterClass() {
	  MethodUtil.executeJSClick(wd, LoginPage.getLogout(wd));
	  MethodUtil.waitAndCloseDriver(wd, 1000);
	  wd.quit();
  }

  @BeforeTest(groups= {"VP","Trainer"})
  public void beforeTest() {
	  LoginPage.goToAssignForce(wd);
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
