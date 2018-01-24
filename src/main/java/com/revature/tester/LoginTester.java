package com.revature.tester;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;

public class LoginTester {
	WebDriver wd;
	Properties props = new Properties();

	@BeforeSuite
	public void getDriverAndLoadProperties() {
		try {
			FileInputStream in = new FileInputStream("src/main/resources/locators.properties");
			props.load(in);
			in.close();
			wd = DriverFactory.getDriver("chrome");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void VerifyProperties() {
	   assertEquals("http://dev.assignforce.revaturelabs.com/home", props.getProperty("EntryURL"));
	}

	@Test(groups= {"VP"})
	public void testVPLogin() {
		wd.get("http://dev.assignforce.revaturelabs.com/home");
		LoginPage.getUsernameInput(wd).sendKeys("test.vpoftech@revature.com.int1");
		LoginPage.getPasswordInput(wd).sendKeys("p@$$w0rd1");
		LoginPage.getLoginBtn(wd).click();
	}
	
	@Test(enabled=false,groups= {"Trainer"})
	public void testTrainerLogin() {
		wd.get("http://dev.assignforce.revaturelabs.com/home");
		LoginPage.getUsernameInput(wd).sendKeys("test.trainer@revature.com.int1");
		LoginPage.getPasswordInput(wd).sendKeys("p@$$w0rd2");
		LoginPage.getLoginBtn(wd).click();
	}
	
	@Test(enabled=false)
	public void testOnLoginPage() {
		wd.get("http://dev.assignforce.revaturelabs.com/home");
		assertEquals("Login | Salesforce",wd.getTitle());
	}

}
