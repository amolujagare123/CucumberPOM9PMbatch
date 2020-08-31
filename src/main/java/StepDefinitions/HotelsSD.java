package StepDefinitions;

import Pages.HotelsHomePage;
import Pages.HotelsSearchResult;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

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

        System.out.println(stars); // 5 stars

        String expectedStar = stars.split(" ")[0]+"-star"; // 5-star
        System.out.println(expectedStar);

        ArrayList<String> starList = hotelsSearchResult.getStarList();

        System.out.println(starList);

        // here we have to check whether in the 'starList' all stars are
        // 1. same
        // 2. perticular star e.g. 5-star



        int frequency = Collections.frequency(starList,expectedStar);
        // occurance of the element in the collection say '5-star'

        System.out.println("frequency/occarance:"+frequency);
        int size = starList.size();

        System.out.println("size:"+size);
        // if occurance of the element in the collection is equal to size of the list
        // it means that all elements are same

       boolean result = frequency==size;

        System.out.println("result:"+result);

        Assert.assertTrue("All stars are not:"+stars,result);


    }


    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String dealPricestr)  {

        hotelsSearchResult.clickRatings("4");

        int expectedDealPrice = Integer.parseInt(dealPricestr);

        System.out.println("expectedDealPrice:"+expectedDealPrice);

        int actualDealprice = hotelsSearchResult.getdealPrice();

        boolean result =  actualDealprice<expectedDealPrice;

        Assert.assertTrue("actal price ("+actualDealprice+") is greater than deal price:"
                +expectedDealPrice,result);




    }

    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of airport$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_airport(String expectedKMStr) {

        int expectedKM = Integer.parseInt(expectedKMStr);

        ArrayList<Double> distList = hotelsSearchResult.getDistanceAirportList();
        System.out.println(distList);

        boolean result = true;

        ArrayList<Double> greaterDistance = new ArrayList<>();
        for(int i=0;i<distList.size();i++)
        {
            if(distList.get(i)>expectedKM)
            {
                greaterDistance.add(distList.get(i));
                result = false;

            }

        }

        Assert.assertTrue("some distances are greater than:"+expectedKMStr
                +"\nbelow is the greater distance list\n"+greaterDistance,result);

    }

    @And("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String hotelName)  {

        ArrayList<String> hotelsList = hotelsSearchResult.getHotelsnamelist();
        System.out.println(hotelsList);

        boolean result = false;

        for(int i=0;i<hotelsList.size();i++)
        {
            if(hotelsList.get(i).contains(hotelName))
            {
                result = true;
                break;
            }
        }

        Assert.assertTrue("the hote :'"+hotelName+"' is not there in the search result",result);


    }

}
