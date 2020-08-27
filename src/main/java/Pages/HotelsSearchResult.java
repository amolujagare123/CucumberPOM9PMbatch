package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResult extends BasePage {

   By starlist  = By.xpath("//span[contains(@class,'star-rating-text')]");
   By dealPrice = By.xpath("//li[contains(@class,'deal-of-the-day')]//ins");


   public int getdealPrice()
   {
       String dealPriceRaw = getTextFromElement(dealPrice)    ;    // "Rs2,949"
       System.out.println("dealPriceRaw:"+dealPriceRaw);


       String dealpriceWithoutRS = dealPriceRaw.substring(2); // "2,949"
       System.out.println("dealpriceWithoutRS:"+dealpriceWithoutRS);

       String dealpriceStr ="";

       for(int i=0;i<dealpriceWithoutRS.length();i++)
       {

           if(dealpriceWithoutRS.charAt(i)!=',')
               dealpriceStr = dealpriceStr + dealpriceWithoutRS.charAt(i);

       }
       System.out.println("dealpriceStr:"+dealpriceStr);

// dealpriceStr  = "2949"

       int dealPrice = Integer.parseInt(dealpriceStr);

       System.out.println("dealprice:"+dealPrice);

       return dealPrice;
   }


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
