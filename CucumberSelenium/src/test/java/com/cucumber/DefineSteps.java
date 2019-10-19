package com.cucumber;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/com/cucumber/demo.feature"})
public class DefineSteps {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("^I open web \"([^\"]*)\"$")
	public void i_open_web(String baseUrl) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}


	@When("^I enter username is \"([^\"]*)\" and password is \"([^\"]*)\"$")
	public void i_enter_username_is_and_password_is(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}
	
	@And("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("btn-default")).click();
	}

	
	@Then("^I login successfully$")
	public void i_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		int size = driver.findElements(By.id("topNavPic")).size();
		if (size != 1) {
		  	fail("Login fail");
		}
	}
	
	@Then("^I receive \"([^\"]*)\"$")
	public void i_receive(String notification) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		int size = driver.findElements(By.className("alert-danger")).size();
	    if (size != 1) {
	    	fail("We want to receive an alert  but we don't receive anything");
	    } else {
	    	String text = driver.findElement(By.className("alert-danger")).getText();
	    	if (!text.equals(notification)) {
	    		fail("Invalid notification text, we want \""+notification + "\", but actual is \"" + text+"\"");
	    	}
	    }
	}
}
