package com.revature.tester;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;

public class LoginTester {
	static WebDriver wd = DriverFactory.getDriver("chrome");
	static Properties props = new Properties();

	@BeforeSuite
	public static void loadProperties() {
		MethodUtil.loadPropertiesFile(props);
	}
	
	@AfterClass
	public static void logout() {
		MethodUtil.waitForLoad(wd, "(//button)[1]").click();
	}
	
	@AfterSuite
	public static void closeDriver() {
		MethodUtil.waitAndCloseDriver(wd,Long.parseLong(props.getProperty("WaitTimeBeforeClosing")));
	}
	
	@BeforeTest
	public static void VerifyProperties() {
	   assertEquals("http://dev.assignforce.revaturelabs.com/", props.getProperty("EntryURL"));
	}

	@Test(groups= {"VP"},priority=2)
	public static void testVPLogin() {
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("VPUsername"), props.getProperty("VPPassword"));
	}
	
	@Test(enabled=false,groups= {"Trainer"})
	public static void testTrainerLogin() {
		wd.get(props.getProperty("EntryURL"));
		LoginPage.loginAs(wd, props.getProperty("TrainerUsername"), props.getProperty("TrainerPassword"));
	}
	
	@Test(enabled=true,priority=1)
	public static void testIfOnLoginPage() {
		wd.get(props.getProperty("EntryURL"));
		assertEquals("Login | Salesforce",wd.getTitle());
	}

}
