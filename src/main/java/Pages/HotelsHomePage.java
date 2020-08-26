package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HotelsHomePage extends BasePage {

    By txtCity = By.xpath("//input[@id='qf-0q-destination']");
    By btnSearch = By.xpath("//button[contains(text(),'Search')]");



    public  void setTxtCity(String city)
    {
       // setValue(txtCity,city);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+city+"')",driver.findElement(txtCity));

    }


    public void clicksearch() {
      clickOn(btnSearch);
    }



}
