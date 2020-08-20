package StepDefinitions;

import Pages.DarkskyHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DarkSkySD {

    DarkskyHomePage darkskyHomePage = new DarkskyHomePage();

    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page()  {

    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline()
    {

        int expected = darkskyHomePage.getTempMain();
        int actual = darkskyHomePage.getTempTimeLine();

        System.out.println("Expected temp="+expected);

        System.out.println("Actual temp="+actual);

        Assert.assertEquals("there is a difference in temperatures",expected,actual);

    }
}
