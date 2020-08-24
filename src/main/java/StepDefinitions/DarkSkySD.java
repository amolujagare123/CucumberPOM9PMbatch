package StepDefinitions;

import Pages.DarkskyHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;

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

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() throws Throwable {
          ArrayList<Integer> timeList = darkskyHomePage.getTimeListInt();
        System.out.println(timeList);

        ArrayList<Integer> expectedList = new ArrayList<>();

        for (int i =0;i<10;i++)
        {
            expectedList.add(2);
        }

        System.out.println(expectedList);

        ArrayList<Integer> actualList = new ArrayList<>();

        for(int i=0;i<timeList.size()-1;i++)
        {
            int time1= timeList.get(i);
            int time2= timeList.get(i+1);
            int timeDiff =0;

            if(time1>time2)
             timeDiff = (12+time2)-time1;
            if(time2>time1)
                timeDiff = time2-time1;


            actualList.add(timeDiff);


        }

        System.out.println(actualList);

        Assert.assertEquals("some time differences are not 2",expectedList,actualList);

    }

}
