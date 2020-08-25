package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class DarkskyHomePage extends BasePage {

       By tempMainTxt = By.xpath("//span[@class='summary swap']");

       By tempTimelineTxt = By.xpath("//span[@class='first']//span");

       By timeline = By.xpath("//span[@class='hour']/span");

       By expander = By.xpath("//a[@data-day='0']//span[@class='toggle']");

       By minTempBarText = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
       By maxTempBarText = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");

    By minTempTimelineText = By.xpath("//div[@class='dayDetails revealed']//span[contains(@class,'high')]/span[1]") ;
    By maxTempTimelineText = By.xpath("//div[@class='dayDetails revealed']//span[contains(@class,'low')]/span[1]") ;



    public ArrayList<Integer> getBarTempList()
    {
        ArrayList<Integer> tempList = new ArrayList<>();

        int minTemp = Integer.parseInt(getTextFromElement(minTempBarText).split("˚")[0]); //69˚
        int maxTemp = Integer.parseInt(getTextFromElement(maxTempBarText).split("˚")[0]); //69˚

        tempList.add(minTemp);
        tempList.add(maxTemp);

        System.out.println("BarTempList"+tempList);
         return tempList;
    }


    public ArrayList<Integer> getTimeLineTempList()
    {
        ArrayList<Integer> tempList = new ArrayList<>();

        int minTemp = Integer.parseInt(getTextFromElement(minTempTimelineText).split("˚")[0]); //69˚
        int maxTemp = Integer.parseInt(getTextFromElement(maxTempTimelineText).split("˚")[0]); //69˚

        tempList.add(minTemp);
        tempList.add(maxTemp);

        System.out.println("TimeLineTempList="+tempList);
        return tempList;
    }

       public void clickExpand()
       {
           JavascriptExecutor js = (JavascriptExecutor) driver;

           js.executeScript("window.scrollBy(0,900)", "");

           js.executeScript("arguments[0].click()",driver.findElement(expander));

          // clickOn(expander);

       }


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
