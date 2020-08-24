package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkskyHomePage extends BasePage {

       By tempMainTxt = By.xpath("//span[@class='summary swap']");

       By tempTimelineTxt = By.xpath("//span[@class='first']//span");

       By timeline = By.xpath("//span[@class='hour']/span");

       public ArrayList<Integer> getTimeListInt()
       {
           ArrayList<String> timeListstr = getElementTextList(timeline);
           System.out.println(timeListstr);

           ArrayList<Integer> timeListint = new ArrayList<>();

           for(int i=0;i<timeListstr.size();i++)
           {

               String timetext = timeListstr.get(i);
               int l = timetext.length();

               String timetextStr = timetext.substring(0,l-2);

               int timeInt =  Integer.parseInt(timetextStr);

               timeListint.add(timeInt);

           }


           return timeListint;
       }


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
