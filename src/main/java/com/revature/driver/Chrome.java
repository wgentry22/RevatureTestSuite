package com.revature.driver;

import java.io.File;
import java.net.URL;
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
			URL resource = MethodUtil.class.getClassLoader().getResource("chromedriver");
			f = new File(resource.getFile());
			System.setProperty(props.getProperty("ChromeDriverName"), f.getAbsolutePath());
		} else {
			URL resource = MethodUtil.class.getClassLoader().getResource("chromedriver.exe");
			f = new File(resource.getFile());
			System.out.println("Chrome driver path:"+f.getAbsolutePath());
			System.setProperty(props.getProperty("ChromeDriverName"), f.getAbsolutePath());
		}
		return new ChromeDriver(); 
	}
}
