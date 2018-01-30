package com.revature.tester.test;

import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.ProfilePage;
import com.revature.tester.MethodUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class ProfileTest {
	WebDriver wd = DriverFactory.getDriver("chrome");

	public void clickSaveSkill(WebDriver wd) {
		ProfilePage.selectSaveSkill(wd).click();
	}

	public void clickCurrentSkillByName(WebDriver wd, String skillName) {
		for (WebElement we : ProfilePage.getCurrentSkillList(wd)) {
			System.out.println(we.getText());
			if (we.getText().contains(skillName.toUpperCase())) {
				we.click();
				return;
			}
		}
		throw new NoSuchElementException(skillName + " was not found");
	}

	public void clickChooseSkillByName(WebDriver wd, String skillName) {
		for (WebElement we : ProfilePage.getChooseSkillList(wd)) {
			System.out.println(we.getText());
			if (we.getText().contains(skillName)) {
				we.click();
				return;
			}
		}
		throw new NoSuchElementException(skillName + " was not found");
	}

	public void clickFirstChooseSkill(WebDriver wd) {
		ProfilePage.selectChooseSkill(wd).click();
	}
	
	public void clickFirstCurrentSkill(WebDriver wd) {
		ProfilePage.selectCurrentSkill(wd).click();
	}
	
	public void getChooseSkillList() {
		ProfilePage.getChooseSkillList(wd);
	}
	
	public void getCurrentSkillList() {
		ProfilePage.getCurrentSkillList(wd);
	}
	
	@Test(groups = "Trainer")
	public void clickProfileTab() {
		ProfilePage.selectProfileTab(wd).click();
	}

	@Test(groups = "Trainer", priority = 5, dependsOnMethods = "clickProfileTab")
	public void changeName() {
		ProfilePage.insertFirstname(wd).clear();
		ProfilePage.insertFirstname(wd).sendKeys("NotTest?");
		ProfilePage.insertLastname(wd).clear();
		ProfilePage.insertLastname(wd).sendKeys("Probably");
	}

	@Test(groups = "Trainer", priority = 7, dependsOnMethods = "clickProfileTab")
	public void addResume() {
		ProfilePage.selectAddResume(wd).click();
	}

	@Test(groups = "Trainer", priority = 4, dependsOnMethods = "clickProfileTab")
	public void saveSkills() {
		boolean done = false;
			try {
				clickCurrentSkillByName(wd, "Not William WebDriver");
				done = true;
				Thread.sleep(800);
				clickChooseSkillByName(wd, "Not William WebDriver");
			} catch (NoSuchElementException e) {
				try {
					if(!done) {
				clickChooseSkillByName(wd, "Not William WebDriver");
				Thread.sleep(800);
				clickCurrentSkillByName(wd, "Not William WebDriver");
					}
					else throw new NoSuchElementException("",e);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clickSaveSkill(wd);
			int chooseSkillList = ProfilePage.getChooseSkillList(wd).size()/2;
			for(int i = 0; i < chooseSkillList; i++)
				clickFirstChooseSkill(wd);
			int currentSkillList = ProfilePage.getCurrentSkillList(wd).size();
			for(int i = 0; i < currentSkillList; i++)
				clickFirstCurrentSkill(wd);
	}

	@BeforeMethod(groups = "Trainer")
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass(groups = "Trainer")
	public void loginAsTrainer() {
		LoginPage.getUsernameInput(wd).sendKeys("test.trainer@revature.com.int1");
		LoginPage.getPasswordInput(wd).sendKeys("trainer123");
		LoginPage.getLoginBtn(wd).submit();
	}

	@AfterClass(groups = "Trainer")
	public void logout() {
		MethodUtil.executeJSClick(wd, LoginPage.getLogout(wd));
	}

	@BeforeTest(groups = "Trainer")
	public void openWebDriverToAssignForce() {
		LoginPage.goToAssignForce(wd);
	}

	@AfterTest(groups = "Trainer")
	public void closeDriver() {
		MethodUtil.waitAndCloseDriver(wd, 1000);
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
