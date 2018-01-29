package com.revature.driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Chrome implements IDriver{

	public WebDriver selectDriver() {
		File f = null;
		if (System.getenv("PATH").contains("/home/")) {
			f = new File("src/main/resources/chromedriver");
			System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
			return new ChromeDriver();
		} else {
			//f = new File("src/main/resources/chromedriver.exe");
			f = new File("C:/git_repos/RevatureTestSuite/src/main/resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
			return new ChromeDriver();
		}
	}
}
