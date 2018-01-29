package com.revature.driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class Firefox implements IDriver {

	 public WebDriver selectDriver() {
		File f = null;
		if (System.getenv("PATH").contains("/home/")) {
			f = new File("src/main/resources/geckodriver");
			System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
			return new FirefoxDriver();
		} else {
			//f = new File("src/main/resources/geckodriver.exe");
			f = new File("C:/git_repos/RevatureTestSuite/src/main/resources/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
			return new FirefoxDriver();
		}
	}
}
