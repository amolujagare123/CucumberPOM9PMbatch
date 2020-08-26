package StepDefinitions;

import Pages.HotelsHomePage;
import Pages.HotelsSearchResult;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class HotelsSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();
    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

        hotelsHomePage.setTxtCity("Mumbai, India");
        hotelsHomePage.clicksearch();
    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {

        String rating =stars.split(" ")[0] ; // stars --> 5 stars

        hotelsSearchResult.clickRatings(rating);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

        ArrayList<String> starList = hotelsSearchResult.getStarList();

        System.out.println(starList);


    }


}
