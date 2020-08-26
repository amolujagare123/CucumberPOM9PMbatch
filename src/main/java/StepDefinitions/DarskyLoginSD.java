package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DarskyLoginSD {

    LoginPage loginPage = new LoginPage();

    @Given("^I am on the darksky Login page$")
    public void i_am_on_the_darksky_login_page() throws Throwable {

        loginPage.clickLnkDarkSkyAPI();
        loginPage.clickLnkLogin();

    }

    @When("^I click on Login button$")
    public void i_click_on_login_button() throws Throwable {
       loginPage.clickbtnLogin();
    }

    @Then("^I verify I am on Login page by asserting Login page title$")
    public void i_verify_i_am_on_login_page_by_asserting_login_page_title() throws Throwable {

        String expected ="Dark Sky API: Log In";
        System.out.println(expected);

        String actual = SharedSD.getDriver().getTitle();
        System.out.println(actual);

        Assert.assertEquals("we are not on the login page",expected,actual);


    }

}
