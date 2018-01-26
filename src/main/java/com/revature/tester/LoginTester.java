package com.revature.tester;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		try {
			FileInputStream in = new FileInputStream("src/main/resources/locators.properties");
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public static void logout() {
		wd.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button")).click();
	}
	
	@BeforeTest
	public static void VerifyProperties() {
	   assertEquals("http://dev.assignforce.revaturelabs.com/", props.getProperty("EntryURL"));
	}

	@Test(groups= {"VP"},priority=2)
	public static void testVPLogin() {
		wd.get("http://dev.assignforce.revaturelabs.com/");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "p@$$w0rd1");
	}
	
	@Test(enabled=false,groups= {"Trainer"})
	public static void testTrainerLogin() {
		wd.get("http://dev.assignforce.revaturelabs.com/");
		LoginPage.loginAs(wd, "test.trainer@revature.com.int1", "trainer123");
	}
	
	@Test(enabled=true,priority=1)
	public static void testIfOnLoginPage() {
		wd.get("http://dev.assignforce.revaturelabs.com/");
		assertEquals("Login | Salesforce",wd.getTitle());
	}

}
