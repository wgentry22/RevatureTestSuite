package com.revature.tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LocationsPage;
import com.revature.pageObjectModel.LoginPage;

public class LocationTester {

	static WebDriver wd = null;
	static WebDriverWait wait = null;
	static Actions act = null;
	
	static String locationName;
	static String locationCity;
	static String locationState;
	
	static String buildingName;
	static String newBuildingName;
	
	static String roomName;
	
	@BeforeGroups(enabled = true, groups = {"VP", "VP1", "VP2"})
	public static void loginAsVP() {
		
		wd = DriverFactory.getDriver("chrome");
		wd.get("https://dev.assignforce.revaturelabs.com");
		LoginPage.loginAs(wd, "test.vpoftech@revature.com.int1", "yuvi1712");

		// Use Dummy Values When You Run Tests
		locationName = "Test_1.66";
		locationCity = "Austin";
		locationState = "TX";
		buildingName = "Random_1.66";
		newBuildingName = "Reston 11730 - Test_1.66";
		roomName = "Test_Room_1.66";

		wait = new WebDriverWait(wd, 30);
		act = new Actions(wd);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a")));
		wd.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a")).click();
	}
	
	@AfterGroups(enabled = true, groups = {"VP", "VP1", "VP2"})
	public static void logout() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		LoginPage.logout(wd);
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}
	
	@Test(enabled = true, groups = "VP", priority = 0)
	public static void addLocation() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click*='lCtrl.addLocation()']")));
		LocationsPage.newLocationButton(wd).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='ldCtrl.location.name']")));
		LocationsPage.newLocationName(wd).sendKeys(locationName);
		LocationsPage.newLocationCity(wd).sendKeys(locationCity);
		LocationsPage.newLocationState(wd).sendKeys(locationState);
		LocationsPage.saveButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP", priority = 1)
	public static void addBuilding() {		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label*='Toggle  "+ locationCity + ", " + locationState +"']")));
		LocationsPage.locationCheckBox(wd, locationCity, locationState).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bldgAdd")));
		LocationsPage.newBuildingButton(wd).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bldgCtrl.building.name']")));
		LocationsPage.newBuildingName(wd).sendKeys(buildingName);
		LocationsPage.saveButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP", priority = 2)
	public static void addRoom() {

		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loc1\"]/md-list-item[2]/div/div[1]/md-checkbox")));
		act.moveToElement(LocationsPage.buildingCheckBox(wd)).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roomAdd")));
		act.moveToElement(LocationsPage.newRoomButton(wd)).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model*='rdCtrl.room.roomName']")));
		LocationsPage.newRoomName(wd).sendKeys(roomName);
		LocationsPage.saveButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP", priority = 3)
	public static void editBuilding() {

		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loc1\"]/md-list-item[2]/div/div[1]/md-checkbox")));
		act.moveToElement(LocationsPage.buildingCheckBox(wd)).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locEdit")));
		act.moveToElement(LocationsPage.editButton(wd)).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='bldgCtrl.building.name']")));
		LocationsPage.newBuildingName(wd).clear();
		LocationsPage.newBuildingName(wd).sendKeys(newBuildingName);
		LocationsPage.saveButton(wd).click();
	}

	@Test(enabled = true, groups = "VP", priority = 4)
	public static void deactivateLocation() {

		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label*='Toggle  "+ locationCity + ", " + locationState +"']")));
		LocationsPage.locationCheckBox(wd, locationCity, locationState).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='lCtrl.deleteSelected()']")));
		LocationsPage.deactivateButton(wd).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-click='dCtrl.delete()']")));
		LocationsPage.confirmDeactivate(wd).click();
	}
}
