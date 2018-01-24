package com.revature.driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

	private static WebDriver webdriver = null;
	
	
	public static ChromeDriver selectDriver() {
		File f = null;
		if (System.getenv("PATH").contains("/home/")) {
			f = new File("src/main/resources/chromedriver");
			System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
			return new ChromeDriver();
		} else {
			f = new File("src/main/resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
			return new ChromeDriver();
		}
	}

//	public static void main(String[] args) {
//		WebDriver driver = Chrome.selectDriver();
//		driver.get("http://google.com");
//		driver.quit();
//	}
}
