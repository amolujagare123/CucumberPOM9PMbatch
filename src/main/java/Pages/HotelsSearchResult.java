package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResult extends BasePage {

   By starlist  = By.xpath("//span[contains(@class,'star-rating-text')]");
   By dealPrice = By.xpath("//li[contains(@class,'deal-of-the-day')]//ins");
   By distanceAirPort = By.xpath("//ul[@class='property-landmarks']//li[2]");

   By hotelNameList  = By.xpath("//a[@class='property-name-link']");

   public  ArrayList<String> getHotelsnamelist()
   {
       return getElementTextList(hotelNameList);
   }


   public ArrayList<Double> getDistanceAirportList()
   {
       ArrayList<Double> distList = new ArrayList<>();

       ArrayList<String> distlistStr = getElementTextList(distanceAirPort);
       // "3.5 km to Chhatrapati Shivaji International Airport (BOM)"

       for(int i=0;i<distlistStr.size();i++)
       {
           String distanceText = distlistStr.get(i);
           String distanceStr = distanceText.split(" ")[0]; // 3.5 in string
           double distance = Double.parseDouble(distanceStr);

           distList.add(distance);
       }





       return  distList;

   }



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
