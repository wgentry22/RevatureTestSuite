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
	
	public static WebElement waitForLoad(WebDriver driver, String xpath, int nTimes200Mill) {
		int times = 0;
		WebElement element = null;
		while(element == null) {
			try {
				element = driver.findElement(By.xpath(xpath));
			} catch(NoSuchElementException e) {
				if(times < nTimes200Mill) {

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
		return element;
	}
	
	public static WebElement waitForLoad(WebDriver driver, String xpath) {
		return waitForLoad(driver, xpath, 10);
	}
	
	
	public static WebElement waitForLoadByAnyType(WebDriver driver, By byType, int nTimes200Mill) {
		int times = 0;
		WebElement element = null;
		while(element == null) {
			try {
				element = driver.findElement(byType);
			} catch(NoSuchElementException e) {
				if(times < nTimes200Mill) {

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
		return element;
	}

	public static WebElement waitForLoadByAnyType(WebDriver driver, By byType) {
		return waitForLoadByAnyType(driver, byType, 10);
	}
	
	public static void loadPropertiesFile(Properties props) {
		try {
			//FileInputStream in = new FileInputStream("src/main/resources/locators.properties");
			//FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\locators.properties");
			FileInputStream in = new FileInputStream("C:/git_repos/RevatureTestSuite/src/main/resources/locators.properties");
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
