package com.revature.tester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.hibernate.model.Room;
import com.revature.hibernate.util.AssignForce;
import com.revature.pageObjectModel.LocationsPage;
import com.revature.pageObjectModel.LoginPage;

public class LocationTester {

	static WebDriver wd = null;
	static Room room = AssignForce.getAllRooms().get(6);
	
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
		locationName = room.getLocationName();			//"Test_1.38";
		locationCity = room.getLocationCity();			//"Austin";
		locationState = room.getLocationState();		//"TX";
		buildingName = room.getBuildingName();			//"Random_1.38";
		newBuildingName = "Reston 11730";
		roomName = room.getRoomNumber();				//"Test_Room_1.38";
		
		MethodUtil.waitForLoad(wd, "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a", 50).click();
//		LocationsPage.navigateToLocationsPage(wd).click();
	}
	
	@AfterGroups(enabled = true, groups = {"VP", "VP1", "VP2"})
	public static void logout() {
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LoginPage.getLogout(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		wd.quit();
	}
	
	@Test(enabled = true, groups = "VP", priority = 0)
	public static void addLocation() {

		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// waits for page to load
		LocationsPage.newLocationButton(wd).click();
		
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		// waits for dialog box to open
		LocationsPage.newLocationName(wd).sendKeys(locationName);
		LocationsPage.newLocationCity(wd).sendKeys(locationCity);
		LocationsPage.newLocationState(wd).sendKeys(locationState);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP", priority = 1)
	public static void addBuilding() {		

		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.locationCheckBox(wd, locationCity, locationState).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.newBuildingButton(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.newBuildingName(wd).sendKeys(buildingName);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP", priority = 2)
	public static void addRoom() {

		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.buildingCheckBox(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.newRoomButton(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.newRoomName(wd).sendKeys(roomName);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}
	
	@Test(enabled = true, groups = "VP", priority = 3)
	public static void editBuilding() {

		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.buildingCheckBox(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.editButton(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.newBuildingName(wd).clear();
		LocationsPage.newBuildingName(wd).sendKeys(newBuildingName);
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }		//Added by William for his slow machine
		LocationsPage.saveButton(wd).click();
	}

	@Test(enabled = true, groups = "VP", priority = 4)
	public static void deactivateLocation() {

		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.locationCheckBox(wd, locationCity, locationState).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.deactivateButton(wd).click();
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		LocationsPage.confirmDeactivate(wd).click();
	}
}
