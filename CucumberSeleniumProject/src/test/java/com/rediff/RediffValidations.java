package com.rediff;

import com.rediff.connector.WebConnector;

import cucumber.api.java.en.Then;

public class RediffValidations {
	WebConnector con;
	
	public RediffValidations(WebConnector con) {
		this.con=con;
	}

	
	@Then("^Login should be ([a-zA-Z0-9]{1,})$")
	public void validateLogin(String expectedResult) {
		
		con.log("Login should be "+expectedResult);
		// VALIDATE LOGIN
		boolean present = con.isElementPresent("signOut_xpath");
		String actualResult="";
		if(present)
			actualResult="success";
		else
			actualResult="failure";
		
		// validation , assertion- Assertion
		if(!actualResult.equals(expectedResult))
			con.reportFailure("Actual result as "+actualResult);
	}
	
    @Then("^Portfolio should be created ([a-zA-Z0-9]{1,})$")
    public void validatePortFolioCreation(String expectedResult) {
    	System.out.println("Portfolio should be created "+expectedResult);
    }

}
