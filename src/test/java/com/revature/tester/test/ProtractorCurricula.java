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

public class ProtractorCurricula {
	
	WebDriver driver = DriverFactory.getDriver("Chrome");

	@BeforeTest
	public void loginVP() {
		CirriculaPage.loginVPCredentials(driver);
	}

//	@BeforeTest(groups = "Trainer")
//	public void loginTrainer() {
//		CirriculaPage.loginTrainerCredentials(driver);
//	}

	@BeforeSuite
	public void beforeSuite() {
		CirriculaPage.openSalesforceChrome(driver);
		try {
			Runtime.getRuntime().exec("webdriver-manager start");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void shutdownWebdriverManager() {
		try {
			Runtime.getRuntime().exec("^C");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
		driver.quit();
	}
	
	
	@Test
	public void runProtractorTests() {
		try {
			Runtime.getRuntime().exec("protractor /home/gtrain/automation/protractor/config.js");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
