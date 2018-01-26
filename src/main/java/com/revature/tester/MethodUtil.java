package com.revature.tester;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MethodUtil {

	public static WebElement waitForLoad(WebDriver driver, String xpath) {
		WebElement element = null;
		int times = 0;
		while(element == null) {
			try {
				element = driver.findElement(By.xpath(xpath));
			} catch(NoSuchElementException e) {
				if(times < 10) {
					try {
						times++;
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				else {
					e.printStackTrace();
					throw new NoSuchElementException("Element did not load in time", e);
				}
			}
		}
		times = 0;
		return element;
	}
	
	public static void loadPropertiesFile(Properties props) {
		try {
			FileInputStream in = new FileInputStream("src/main/resources/locators.properties");
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitAndCloseDriver(WebDriver wd, long millisecondsToWait) {
		try {
			Thread.sleep(millisecondsToWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			wd.close();
		}
	}
	
	public static void executeJSClick(WebDriver wd, WebElement el) {
		JavascriptExecutor executor = (JavascriptExecutor) wd;
		executor.executeScript("arguments[0].click();", el);
	}
}
