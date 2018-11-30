$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com/rediff/portfolio.feature");
formatter.feature({
  "name": "Creation and deletion of portfolio",
  "description": "  I want to create and delete portfolios",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Portfolio"
    }
  ]
});
formatter.scenario({
  "name": "Create a Portfolio",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Portfolio"
    },
    {
      "name": "@CreatePortfolio"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open Chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to loginPage",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login with default username and password",
  "keyword": "When "
});
formatter.match({
  "location": "AppSteps.defaultLogin()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.rediff.connector.WebConnector.type(WebConnector.java:84)\r\n\tat com.rediff.AppSteps.defaultLogin(AppSteps.java:18)\r\n\tat ✽.I login with default username and password(src/test/resources/com/rediff/portfolio.feature:27)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Login should be success",
  "keyword": "Then "
});
formatter.match({
  "location": "RediffValidations.validateLogin(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on createPortfolioButton_id",
  "keyword": "When "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I clear portfolioNameText_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.clear(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I type Dec18 in portfolioNameText_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.type(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on createPortfolioSubmitButton_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Portfolio should be created successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "RediffValidations.validatePortFolioCreation(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});