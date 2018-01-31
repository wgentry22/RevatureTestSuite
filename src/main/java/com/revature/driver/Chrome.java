package com.revature.driver;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.tester.MethodUtil;

class Chrome implements IDriver{

	public WebDriver selectDriver() {
	Properties props = new Properties();
	MethodUtil.loadPropertiesFile(props);
		File f = null;
		if (System.getenv("PATH").contains("/home/")) {
			f = new File("src/main/resources/chromedriver");
			System.setProperty(props.getProperty("ChromeDriverName"), f.getAbsolutePath());
		} else {
			//f = new File(System.getProperty("user.dir") + props.getProperty("ChromeDriverPathWindows"));
			f = new File("C:/git_repos/RevatureTestSuite/src/main/resources/chromedriver.exe");
			System.out.println(f.getAbsolutePath());
			System.setProperty(props.getProperty("ChromeDriverName"), f.getAbsolutePath());
		}
		return new ChromeDriver(); 
	}
}
