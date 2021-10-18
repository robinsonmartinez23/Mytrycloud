package com.tryCloud.step_definitions;

import com.tryCloud.pages.LoginPage;

import com.tryCloud.utilities.BrowserUtil;
import com.tryCloud.utilities.ConfigReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){
        BrowserUtil.waitFor(3);
        Driver.getDriver().get(ConfigReader.read("url"));
        Assert.assertEquals("Trycloud QA", Driver.getDriver().getTitle());
    }
    @When("user enter valid {string} and {string} and user click login button")
    public void userEnterValidUserAndPasswordAndClickLoginButton(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("verify user launched to the dashboard")
    public void verifyUserLaunchedToTheDashboard() {
        BrowserUtil.waitFor(5);
        String expectedTitle = "Dashboard - Trycloud QA";
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }
    @When("user enters invalid credentials and user click login button")
        public void userEnterInvalidCredentials() {
            loginPage.login(ConfigReader.read("invalidUser"), ConfigReader.read("invalidPass"));
    }
    @Then("“Wrong username or password.” message should be displayed")
    public void wrongUsernameOrPasswordMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }

}
