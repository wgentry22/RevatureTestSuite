package com.revature.tester.test;

import static org.testng.Assert.assertTrue;

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
	  TrainerPage.selectTrainersTab(wd);
	  assertTrue(true);
  }
  
  @Test(groups="VP", priority=1)
  public void getAddTrainer() {
	  TrainerPage.selectAddTrainer(wd).click();
	  assertTrue(true);
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
	  LoginPage.getPasswordInput(wd).sendKeys("p@$$w0rd1");
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
