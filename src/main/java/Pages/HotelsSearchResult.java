package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResult extends BasePage {

   By starlist  = By.xpath("//span[contains(@class,'star-rating-text')]");


   // write a method that will get us the list of all texts

    public ArrayList<String> getStarList()
    {
        return getElementTextList(starlist);
    }



    public void clickRatings(String rating) {

        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='f-star-rating-"+rating+"']")).click();
    }

}
