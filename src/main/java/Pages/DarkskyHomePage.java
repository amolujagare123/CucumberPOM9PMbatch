package Pages;

import org.openqa.selenium.By;

public class DarkskyHomePage extends BasePage {

       By tempMainTxt = By.xpath("//span[@class='summary swap']");

       By tempTimelineTxt = By.xpath("//span[@class='first']//span");


       public int getTempMain()
       {
          String tempMain = getTextFromElement(tempMainTxt);

          String tempMainStr = tempMain.split("˚")[0];

          return Integer.parseInt(tempMainStr);
       }

       public int getTempTimeLine()
       {
           String tempTimeline = getTextFromElement(tempTimelineTxt);

           String tempTimelineStr = tempTimeline.split("°")[0];

           return Integer.parseInt(tempTimelineStr);
       }



}
