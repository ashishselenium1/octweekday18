package com.rediff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rediff.connector.WebConnector;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

// generic interactions with browser
public class GenericSteps {
	
	WebConnector con;
	
	public GenericSteps(WebConnector con) {
		this.con=con;
	}
	
	@Before
	public void init() {
		con.initRep();
	}
	
	@After
	public void quit() {
		con.flush();
	}
	
    @Given("^I open ([a-zA-Z0-9]{1,})$")
    public void openBrowser(String bName) {
    	con.log("Opening browser "+bName);
    	con.openBrowser(bName);
    }
    
    @And("^I navigate to ([a-zA-Z0-9]{1,})$")
    public void navigate(String urlKey) {
    	con.log("Navigating to "+ urlKey );
    	con.navigate(urlKey);
    }

	@When("^I click on ([^\"]*)$")
	public void click(String objectKey) {
		con.log("I click on "+objectKey);
		con.click(objectKey);
	}
	
	@And("^I clear ([^\"]*)$")
	public void clear(String objectKey) {
		con.log("I clear "+objectKey);
		con.clear(objectKey);
	}
	
    @And("^I type ([^\"]*) in ([^\"]*)$")
    public void type(String value, String objectKey) {
    	con.log("I type "+value +" in "+objectKey);
    	con.type(value, objectKey);
    }
}
    
	
	
	
	


