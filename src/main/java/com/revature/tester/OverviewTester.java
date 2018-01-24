package com.revature.tester;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.revature.pageObjectModel.OverviewPage;

public class OverviewTester {
	WebDriver wd;
	Properties props;
	
	@Test(groups= {"VP","Trainer"})
	public void testOverviewPage() {
		// navigate to correct page
		wd.get("");
		// get elements
		OverviewPage.getOverviewField(wd).sendKeys("something");
	}
}
