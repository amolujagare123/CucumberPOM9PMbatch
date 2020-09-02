package Pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class HotelsHomePage extends BasePage {

    By txtCity = By.xpath("//input[@id='qf-0q-destination']");
    By btnSearch = By.xpath("//button[contains(text(),'Search')]");
    By selectRooms = By.xpath("//select[@id='qf-0q-rooms']");
    By roomRows = By.xpath("//div[contains(@class,'room-options')]");


    public int getRoomrowCount() // actual result
    {
        return SharedSD.getDriver().findElements(roomRows).size();
    }

    public void selectRoom(String room)
    {

        SharedSD.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        selectFromDropdown(selectRooms,room);
    }



    public  void setTxtCity(String city)
    {
       // setValue(txtCity,city);
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].setAttribute('value','"+city+"')",SharedSD.getDriver().findElement(txtCity));

    }


    public void clicksearch() {
      clickOn(btnSearch);
    }



}
