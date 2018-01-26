package com.revature.tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.TrainerPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.revature.driver.DriverFactory.*;
import static com.revature.pageObjectModel.TrainerPage.*;

public class TrainerTester {

	static WebDriver wd = getDriver("chrome");
	
	public static void main(String[] args) {
		wd.get("https://dev.assignforce.revaturelabs.com");
		login();
	}
	
	static void login() {
		wd.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("test.vpoftech@revature.com.int1");
		wd.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("p@$$w0rd1");
		wd.findElement(By.xpath("//*[@id=\"Login\"]")).submit();
		wd.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]/a")).click();
		selectAddTrainer(wd);
		selectCancelAddTrainer(wd);
		selectViewPTOCalendar(wd);
		
	}
	//WebDriver wd = DriverFactory.getDriver("chrome");
	//This is cucumber code from test. Should be here and not 
	@Given("^I want to go to the \"([^\"]*)\"$")
	public void i_want_to_go_to_the(String arg1) {
	    wd.get(arg1);
	}

	@Given("^I login as \"([^\"]*)\" with a valid \"([^\"]*)\"$")
	public void i_login_as_with_a_valid(String arg1, String arg2) {
	    LoginPage.getUsernameInput(wd).sendKeys(arg1);
	    LoginPage.getPasswordInput(wd).sendKeys(arg2);
	    LoginPage.getLoginBtn(wd).submit();
	}
	@When("^I login, I click on the trainers tab$")
	public void i_login_I_click_on_the_trainers_tab() {
		TrainerPage.selectTrainersTab(wd).click();
	}

	@Then("^I click on the add trainer button$")
	public void i_click_on_the_add_trainer_button() {
		TrainerPage.selectAddTrainer(wd).click();
		
	}
	@Then("^I input \"([^\"]*)\" and \"([^\"]*)\" of the trainer$")
	public void i_input_and_of_the_trainer(String arg1, String arg2) {
	    TrainerPage.insertTrainerFirstname(wd).sendKeys(arg1);
	    TrainerPage.insertTrainerLastname(wd).sendKeys(arg2);
	}
	

	@Then("^I click save$")
	public void i_click_save() {
		TrainerPage.selectSaveNewTrainer(wd).submit();
	}
}
