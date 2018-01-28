package com.revature.tester.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.CirriculaPage;
import com.revature.tester.MethodUtil;

public class CurriculaTest {

	WebDriver driver = DriverFactory.getDriver("chrome");
  @BeforeTest
  public void beforeTest() {
	  CirriculaPage.loginVPCredentials(driver);
  }

  @AfterTest
  public void afterTest() {
	  MethodUtil.executeJSClick(driver, CirriculaPage.logoutTab(driver));
  }

  @BeforeSuite
  public void beforeSuite() {
	  CirriculaPage.openSalesforceChrome(driver);
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
	  driver.quit();
  }
  
  @Test(priority=1, enabled=true)
  public void navigateToCurriculumTab() {
	  CirriculaPage.curriculaTab(driver).click();
  }
  
  
  
  /* Works for both cancel and confirm removing a curriculum */
  
  @Test(priority=3, enabled=true)
  public void removeNthCurriculaButton() {
	  if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
		  try {
			  CirriculaPage.removeNthCurriculaButton(driver, 1).click();
			  Thread.sleep(250);
			  CirriculaPage.cancelRemoveCurriculumButton(driver).click();
			  Thread.sleep(250);
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(150);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
			  Thread.sleep(250);
			  CirriculaPage.removeNthCurriculaButton(driver, 1).click();
			  Thread.sleep(250);
			  CirriculaPage.cancelRemoveCurriculumButton(driver).click();
			  Thread.sleep(250);
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }
  }
  
  
  @Test(priority=4, enabled=true)
  public void editCurriculaButtonAndUpdateName() {
	  if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
		  try {
			  Thread.sleep(400);
			  CirriculaPage.editNthCurriculaPanelButton(driver, 1).click();
			  Thread.sleep(400);
			  CirriculaPage.editCurriculumNameInputField(driver).clear();
			  Thread.sleep(400);
			  CirriculaPage.editCurriculumNameInputField(driver).sendKeys("Definitely William");
			  Thread.sleep(400);
			  CirriculaPage.confirmButtonEditCurriculumPopup(driver).click();
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(150);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
			  Thread.sleep(400);
			  CirriculaPage.editNthCurriculaPanelButton(driver, 1).click();
			  Thread.sleep(400);
			  CirriculaPage.editCurriculumNameInputField(driver).clear();
			  Thread.sleep(400);
			  CirriculaPage.editCurriculumNameInputField(driver).sendKeys("Definitely William");
			  Thread.sleep(400);
			  CirriculaPage.confirmButtonEditCurriculumPopup(driver).click();
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
		  
	  }
	  
  }
  
  
  @Test(priority=7, enabled=true)
  public void editFocusButtonAndEditName() {
	  if (CirriculaPage.isFocusPanelOpen(driver)) {
		  try {
			  Thread.sleep(400);
			  CirriculaPage.editFirstFocusPanelButton(driver).click();
			  Thread.sleep(400);
			  CirriculaPage.textInputEditFocusPopup(driver).clear();
			  Thread.sleep(400);
			  CirriculaPage.textInputEditFocusPopup(driver).sendKeys("Ruby on Rails");
			  Thread.sleep(250);
			  CirriculaPage.confirmButtonEditFocusPopup(driver).click();
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(150);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
			  Thread.sleep(400);
			  CirriculaPage.editFirstFocusPanelButton(driver).click();
			  Thread.sleep(400);
			  CirriculaPage.textInputEditFocusPopup(driver).clear();
			  Thread.sleep(400);
			  CirriculaPage.textInputEditFocusPopup(driver).sendKeys("Ruby on Rails");
			  Thread.sleep(250);
			  CirriculaPage.confirmButtonEditFocusPopup(driver).click();
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
		  
	  }
	  
  }
  
  
  @Test(priority=8, enabled=true)
  public void removeFocusButton() {
	  if (CirriculaPage.isFocusPanelOpen(driver)) {
		  try {
			  Thread.sleep(300);
			  MethodUtil.executeJSClick(driver, CirriculaPage.removeNthButtonFocus(driver, 1));
			  Thread.sleep(300);
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonRemoveFocus(driver));
			  Thread.sleep(200);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(150);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
			  Thread.sleep(300);
			  MethodUtil.executeJSClick(driver, CirriculaPage.removeNthButtonFocus(driver, 1));
			  Thread.sleep(300);
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonRemoveFocus(driver));
			  Thread.sleep(200);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }
  }
  
  
  
  @Test(priority=11, enabled=true)
  public void addSkill() {
	  if (CirriculaPage.isSkillPanelOpen(driver)) {
		  try {
			  Thread.sleep(250);
			  CirriculaPage.addSkillInputField(driver).sendKeys("Not William WebDriver");
			  Thread.sleep(450);
			  MethodUtil.executeJSClick(driver, CirriculaPage.createButtonSkill(driver));
			  Thread.sleep(800);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(100);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleSkillPanel(driver));
			  Thread.sleep(250);
			  CirriculaPage.addSkillInputField(driver).sendKeys("Not William WebDriver");
			  Thread.sleep(450);
			  MethodUtil.executeJSClick(driver, CirriculaPage.createButtonSkill(driver));
			  Thread.sleep(800);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }
  }
  
  
  @Test(priority=12, enabled=true) 
  public void editCurriculumPopupAddSkills() {
	  if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
		  try {
			  Thread.sleep(400);
			  //Opens up Update Curricula Panel
			  MethodUtil.executeJSClick(driver, CirriculaPage.editNthCurriculaPanelButton(driver, 1));
			  Thread.sleep(400);
			  //Activates the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(500);
			  //Gets list of all skills
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(500);
			  //Clicking all options in the dropdown
			  for (int i = 0; i < skills.size(); i++) {
				  skills.get(i).click();
			  }
			  Thread.sleep(500);
//			  //Unclicking all options in dropdown
//			  for (int i = 0; i < skills.size(); i++) {
//				  skills.get(i).click();
//			  }
			  Thread.sleep(500);
			  //Deactivates the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(200);
			  //Cancels the changes
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));
			  
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {

		  try {
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
			  Thread.sleep(400);
			  //Opens up Update Curricula Panel
			  MethodUtil.executeJSClick(driver, CirriculaPage.editNthCurriculaPanelButton(driver, 1));
			  Thread.sleep(400);
			  //Activates the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(500);
			  //Gets list of all skills
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(500);
			  //Clicking all options in the dropdown
			  for (int i = 0; i < skills.size(); i++) {
				  skills.get(i).click();
			  }
			  Thread.sleep(500);
//			  //Unclicking all options in dropdown
//			  for (int i = 0; i < skills.size(); i++) {
//				  skills.get(i).click();
//			  }
			  Thread.sleep(500);
			  //Deactivates the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(200);
			  //Cancels the changes
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));
			  
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }
  }
  
  
  @Test(priority=13, enabled=true)
  public void editFocusPopupAddSkills() {
	  if (CirriculaPage.isFocusPanelOpen(driver)) {
		  try {
			  Thread.sleep(400);
			  //Opens the edit focus panel
			  CirriculaPage.editFirstFocusPanelButton(driver).click();
			  Thread.sleep(400);
			  //Activates the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(500);
			  //Gets all skills from dropdown
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(250);
			  //Clicking all options in the dropdown
			  for (int i = 0; i < skills.size(); i++) {
				  skills.get(i).click();
			  }
//			  Thread.sleep(250);
//			  //Unclicking all options in dropdown
//			  for (int i = 0; i < skills.size(); i++) {
//				  skills.get(i).click();
//			  }
			  Thread.sleep(500);
			  //Deactivate the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(200);
			  //Cancel Changes
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));
			 
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(300);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
			  Thread.sleep(400);
			  //Opens the edit focus panel
			  CirriculaPage.editFirstFocusPanelButton(driver).click();
			  Thread.sleep(400);
			  //Activates the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(500);
			  //Gets all skills from dropdown
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(250);
			  //Clicking all options in the dropdown
			  for (int i = 0; i < skills.size(); i++) {
				  if (i % 6 == 0) {
					  skills.get(i).click();
				  }
			  }
//			  Thread.sleep(250);
//			  //Unclicking all options in dropdown
//			  for (int i = 0; i < skills.size(); i++) {
//				  if (i % 6 == 0) {
//					  skills.get(i).click();
//				  }
//			  }
			  Thread.sleep(500);
			  //Deactivate the dropdown
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(200);
			  //Cancel Changes
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelCurriculumUpdateChanges(driver));
			 
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }
  }
  
  @Test(priority=14, enabled=true)
  public void addNewCurriculum() {
	  if (CirriculaPage.isCoreCurriculaPanelOpen(driver)) {
		  try {
			  Thread.sleep(400);
			  //Opens add new curricula popup
			  MethodUtil.executeJSClick(driver, CirriculaPage.addNewCurriculumButton(driver));
			  Thread.sleep(400);
			  //clears the text field and sends text to the Curriculum Name field
			  CirriculaPage.editCurriculumNameInputField(driver).clear();
			  CirriculaPage.editCurriculumNameInputField(driver).sendKeys("RobinScrippp");
			  Thread.sleep(400);
			  //Opens dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(200);
			  //Add skills to the curriculum
			  for (int i = 0; i < skills.size(); i++) {
				  if (i % 2 == 0) {
					  skills.get(i).click();
				  } 
			  }
			  Thread.sleep(200);
			  //Deactivates dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(200);
			  //Save curriculum
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonEditFocusPopup(driver));
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(150);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleCoreCurriculaPanel(driver));
			  Thread.sleep(230);
			  //Opens add new curricula popup
			  MethodUtil.executeJSClick(driver, CirriculaPage.addNewCurriculumButton(driver));
			  Thread.sleep(200);
			  //clears the text field and sends text to the Curriculum Name field
			  CirriculaPage.editCurriculumNameInputField(driver).clear();
			  CirriculaPage.editCurriculumNameInputField(driver).sendKeys("RobinScrippp");
			  Thread.sleep(200);
			  //Opens dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(200);
			  //Add skills to the curriculum
			  for (int i = 0; i < skills.size(); i++) {
				  if (i % 2 == 0) {
					  skills.get(i).click();
				  } 
			  }
			  Thread.sleep(200);
			  //Deactivates dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(200);
			  //Save curriculum
			  MethodUtil.executeJSClick(driver, CirriculaPage.cancelButtonEditFocusPopup(driver));
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }
  }
  
  
  @Test(priority=15, enabled=true)
  public void addNewFocus() {
	  if (CirriculaPage.isFocusPanelOpen(driver)) {
		  try {
			  Thread.sleep(400);
			  //Opens the add new focus popup
			  MethodUtil.executeJSClick(driver, CirriculaPage.addNewFocusButton(driver));
			  Thread.sleep(200);
			  //Clears the Focus name input field and sends keys
			  CirriculaPage.editCurriculumNameInputField(driver).clear();
			  CirriculaPage.editCurriculumNameInputField(driver).sendKeys("Andrew's Sorcery");
			  Thread.sleep(200);
			  //Opens the dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(200);
			  //Add skills to the curriculum
			  for (int i = 0; i < skills.size(); i++) {
				  if (i % 5 == 0) {
					  skills.get(i).click();
				  } 
			  }
			  Thread.sleep(200);
			  //Deactivates dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(400);
			  //Save curriculum
			  MethodUtil.executeJSClick(driver, CirriculaPage.confirmButtonEditFocusPopup(driver));
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  } else {
		  try {
			  Thread.sleep(150);
			  MethodUtil.executeJSClick(driver, CirriculaPage.toggleFocusPanel(driver));
			  Thread.sleep(200);
			  //Opens the add new focus popup
			  MethodUtil.executeJSClick(driver, CirriculaPage.addNewFocusButton(driver));
			  Thread.sleep(200);
			  //Clears the Focus name input field and sends keys
			  CirriculaPage.editCurriculumNameInputField(driver).clear();
			  CirriculaPage.editCurriculumNameInputField(driver).sendKeys("Andrew's Sorcery");
			  Thread.sleep(400);
			  //Opens the dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  List<WebElement> skills = driver.findElements(By.tagName("md-option"));
			  Thread.sleep(200);
			  //Add skills to the curriculum
			  for (int i = 0; i < skills.size(); i++) {
				  if (i % 5 == 0) {
					  skills.get(i).click();
				  } 
			  }
			  Thread.sleep(200);
			  //Deactivates dropdown list
			  MethodUtil.executeJSClick(driver, CirriculaPage.editSkillsDropdownforCurriculum(driver));
			  Thread.sleep(400);
			  //Save curriculum
			  MethodUtil.executeJSClick(driver, CirriculaPage.confirmButtonEditFocusPopup(driver));
			  
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }
  }
  
  
}
