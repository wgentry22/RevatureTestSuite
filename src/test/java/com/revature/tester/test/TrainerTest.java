package com.revature.tester.test;

import org.openqa.selenium.WebDriver;

import com.revature.driver.DriverFactory;
import com.revature.pageObjectModel.LoginPage;
import com.revature.pageObjectModel.TrainerPage;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@CucumberOptions(features="src/test/resources/trainer.feature")
public class TrainerTest {

	WebDriver wd = DriverFactory.getDriver("chrome");
	
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
	public void i_click_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
