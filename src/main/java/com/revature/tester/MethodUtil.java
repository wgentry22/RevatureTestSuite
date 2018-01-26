package com.revature.tester;



import org.openqa.selenium.By;
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
}
