package com.rediff;

import com.rediff.connector.WebConnector;

import cucumber.api.java.en.When;

public class AppSteps {
	WebConnector con;
	
	public AppSteps(WebConnector con) {
		this.con=con;
	}

	@When("^I login with default username and password$")
	public void defaultLogin() {
		con.log("I login with default username and password");
		String username = con.getProperty().getProperty("defaultusername");
		con.type(username, "username_id");
		con.click("usernameSubmit_xpath");
		String password = con.getProperty().getProperty("defaultPassword");
		con.type(password, "password_xpath");
		con.click("passwordSubmit_id");
	}
}
